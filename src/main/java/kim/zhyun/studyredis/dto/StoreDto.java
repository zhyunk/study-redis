package kim.zhyun.studyredis.dto;

import org.springframework.data.geo.Point;
import org.springframework.data.redis.connection.RedisGeoCommands;

public record StoreDto (
        Long id,
        String name,
        Double x,
        Double y,
        String postcode
) {

    public static StoreDto of (String name, Double x, Double y) {
        return new StoreDto(null, name, x, y, null);
    }
    public static StoreDto of (Long id, String name, Double x, Double y, String postcode) {
        return new StoreDto(id, name, x, y, postcode);
    }
    public RedisGeoCommands.GeoLocation<String> makeGeoLocation(String key) {
        return new RedisGeoCommands.GeoLocation<String>(
                key,
                new Point(x(), y())
        );
    }
}
