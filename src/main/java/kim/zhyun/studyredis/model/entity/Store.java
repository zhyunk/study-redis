package kim.zhyun.studyredis.model.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@ToString
@Getter
@RedisHash(value = "store")
@AllArgsConstructor
public class Store {

    @Id
    private Long id;

    private String name;
    private String address;
    private String addressDetail;
    private String addressExtra;
    private double x;
    private double y;
    private String description;

    private double reviewAverageRating;

}
