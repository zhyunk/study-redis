package kim.zhyun.studyredis.dto;

import org.springframework.data.geo.Point;
import org.springframework.data.redis.connection.RedisGeoCommands;

public record StoreDto (
        String name,
        Double x,
        Double y
) {
    public static StoreDto of (String name, Double x, Double y) {
        return new StoreDto(name, x, y);
    }
    public RedisGeoCommands.GeoLocation<Object> makeGeoLocation() {
        return new RedisGeoCommands.GeoLocation<Object>(name(), new Point(x(), y()));
    }
}
