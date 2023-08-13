package kim.zhyun.studyredis.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import kim.zhyun.studyredis.dto.StoreDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.GeoResult;
import org.springframework.data.geo.Metrics;
import org.springframework.data.geo.Point;
import org.springframework.data.redis.connection.RedisGeoCommands;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.domain.geo.GeoReference;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class RedisGeoService {
    private final RedisTemplate<String, String> redisTemplate;
    private final ObjectMapper objectMapper;

    private final String KEY = "store";

    public void geospecial() {
        List<StoreDto> list = getData();

        save(list);

        search();
    }

    private void save(List<StoreDto> list) {
        redisTemplate.delete(KEY);

        Long added = redisTemplate.opsForGeo().add(
                KEY,
                list.stream()
                    .map(dto -> dto.makeGeoLocation(getJsonFromDto(dto)))
                    .collect(Collectors.toList())
        );
        log.info("added {}", added);
    }

    private void search() {
        redisTemplate.opsForGeo().search(
                KEY,
                GeoReference.fromCoordinate(new Point(127.047365178682, 37.5471882244091)),
                new Distance(100, Metrics.KILOMETERS),
                RedisGeoCommands.GeoRadiusCommandArgs.newGeoRadiusArgs()
                        .sort(Sort.Direction.ASC)
                        .includeCoordinates()
                        .includeDistance()
        ).forEach(result -> {
            log.info(
                    "🗺️ [{}] name : {} , Point : {}, Distance : {}",
                    KEY,
                    getDtoFromJson(result).name(),
                    result.getContent().getPoint(),
                    result.getDistance()
            );
        });
    }

    private static List<StoreDto> getData() {
        return List.of(
                StoreDto.of(1L, "a", 126.290992371209, 34.5121745149379, "1224"),
                StoreDto.of(2L, "b", 127.041688751305, 37.5481104648655, "1244"),
                StoreDto.of(3L, "c", 127.028065727387, 37.4986232309429, "1634"),
                StoreDto.of(4L, "d", 129.300837210054, 35.5507005286619, "1734"),
                StoreDto.of(5L, "e", 127.086439879278, 37.622218884578, "1284"),
                StoreDto.of(6L, "f", 127.111270068545, 37.7337789487014, "1034"),
                StoreDto.of(7L, "g", 127.044608514359, 36.4804589952686, "1934")
        );
    }

    private String getJsonFromDto(StoreDto dto) {
        try {
            return objectMapper.writeValueAsString(dto);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
    private StoreDto getDtoFromJson(GeoResult<RedisGeoCommands.GeoLocation<String>> result) {
        try {
            return objectMapper.readValue(result.getContent().getName(), StoreDto.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
