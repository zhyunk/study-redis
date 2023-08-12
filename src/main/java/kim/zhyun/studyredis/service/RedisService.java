package kim.zhyun.studyredis.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import kim.zhyun.studyredis.dto.StoreDto;
import kim.zhyun.studyredis.dto.TestDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.data.geo.Circle;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Metrics;
import org.springframework.data.geo.Point;
import org.springframework.data.redis.connection.RedisGeoCommands;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.domain.geo.GeoReference;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.*;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class RedisService {

    private final String KEY = "test-key";
    private final RedisTemplate<String, Object> redisTemplate;

    private final ObjectMapper objectMapper;


    public String process(String stringData) {
        // key 유지 시간
        Duration duration = Duration.ofSeconds(5);

        // redis 로 lock 을 잡을 key 를 생성.
        String key = getKey(stringData);
        Boolean isSuccess = redisTemplate.opsForValue().setIfAbsent(key, "create", duration);

        log.info("🐢 isSuccess = {}", isSuccess);

        if (Objects.isNull(isSuccess) || !isSuccess) {
            // 이미 키가 선점되어있으므로, 진행할 수 없습니다.
            return "이미 락이 걸려있습니다.";
        }

        // 여기서 하고싶은 처리를 합니다.
        // 테스트를 위한 코드이므로, 적절히 수정해야 합니다.
        try {
            // key 해제 상황을 확인하기 위한 thread 잠 재우기
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "처리했습니다.";
        // 처리가 일찍 끝나면, lock 으로 잡았던 key 는 해제해줍니다.
        // redisTemplate.unlink(key);
    }

    private String getKey(String stringData) {
        // 보통 redis 는 depth 를 구분할때 : 를 사용한다.
        return KEY + ":" + stringData;
    }

    /**
     * Hash 자료구조
     */
    public void hashData(String data) {
        TestDto testDto = TestDto.of("zhyun", 12345, "/board");

        // 저장된 key가 있는지 확인
        Boolean hasKey = redisTemplate.hasKey(data);

        if (Objects.isNull(hasKey) || !hasKey) {
            // HSET
            redisTemplate.opsForHash().putAll(
                    data,
                    objectMapper.convertValue(testDto, HashMap.class)
            );
        }

        // HGETALL
        Map<Object, Object> map = redisTemplate.opsForHash().entries(data);

        // 값 확인
        log.info("👉 is same {} ", Objects.equals(testDto, objectMapper.convertValue(map, TestDto.class)));
        map.forEach((o, o2) -> log.info("🐢 key :: {} , val :: {}", o, o2));
    }

    /**
     * pipeline
     */
    public void pipeline(String data) {
        List<TestDto> list = List.of(
                TestDto.of("김가나", 12345, "/a"),
                TestDto.of("김다라", 23456, "/b"),
                TestDto.of("김마바", 34567, "/c"),
                TestDto.of("김사아", 45678, "/d"),
                TestDto.of("김자차", 56789, "/e")
        );

        List<Object> pipelined = redisTemplate.executePipelined((RedisCallback<Object>) connection -> {
            RedisSerializer<String> keySerializer = redisTemplate.getStringSerializer();

            list.forEach(dto -> {
                objectMapper.convertValue(dto, Map.class).forEach((key, val) -> {
                    connection.hashCommands().hMSet(
                            keySerializer.serialize("reserve#" + data + UUID.randomUUID()),
                            dto.makeByteMap()
                    );
                });
            });

            return null;
        });

        log.info("pipelined size is {}", pipelined.size());
        pipelined.forEach(o -> log.info("what is {}", o.toString()));
    }

    /**
     * set
     */
    public void set() {
        redisTemplate.opsForSet().add("testSet", TestDto.of("김가나", 12345, "/ㅁ").toString());
        redisTemplate.opsForSet().add("testSet", TestDto.of("김다라", 12345, "/ㄴ").toString());
        redisTemplate.opsForSet().add("testSet", TestDto.of("김가나", 12345, "/ㅁ").toString());
        redisTemplate.opsForSet().add("testSet", TestDto.of("김가나", 12345, "/ㅁ").toString());

        int[] idx = {1};
        log.info("include 👇");
        redisTemplate.opsForSet().members("testSet").forEach(o -> log.info(" {}. {}", idx[0]++, o));
    }

    /**
     * geospecial
     */
    public void geospecial() {
        List<StoreDto> list = List.of(
                StoreDto.of("a", 126.290992371209, 34.5121745149379),
                StoreDto.of("b", 127.041688751305, 37.5481104648655),
                StoreDto.of("c", 127.028065727387, 37.4986232309429),
                StoreDto.of("d", 129.300837210054, 35.5507005286619),
                StoreDto.of("e", 127.086439879278, 37.622218884578),
                StoreDto.of("f", 127.111270068545, 37.7337789487014),
                StoreDto.of("g", 127.044608514359, 36.4804589952686)
        );

        Long added = redisTemplate.opsForGeo().add(
                "store",
                list.stream()
                        .map(StoreDto::makeGeoLocation)
                        .collect(Collectors.toList())
        );
        log.info("added {}",added);

        redisTemplate.opsForGeo().search(
                "store",
                GeoReference.fromCoordinate(new Point(127.047365178682, 37.5471882244091)),
                new Distance(100, Metrics.KILOMETERS),
                RedisGeoCommands.GeoRadiusCommandArgs.newGeoRadiusArgs()
                        .sort(Sort.Direction.ASC)
                        .includeCoordinates()
                        .includeDistance()
        ).forEach(result -> log.info("🐒 {}", result));

    }
}
