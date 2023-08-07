package kim.zhyun.studyredis.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.Objects;

@Slf4j
@Service
@RequiredArgsConstructor
public class RedisService {

    private final String KEY = "test-key";
    private final RedisTemplate<String, String> redisTemplate;


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
}
