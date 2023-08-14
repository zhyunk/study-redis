package kim.zhyun.studyredis.dto;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.data.geo.GeoResult;
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

    public static RedisGeoCommands.GeoLocation<String> toGeoLocation(StoreDto dto) {
        try {
            return new RedisGeoCommands.GeoLocation<String>(
                    new ObjectMapper().writeValueAsString(dto),
                    new Point(dto.x(), dto.y())
            );
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public static StoreDto from(GeoResult<RedisGeoCommands.GeoLocation<String>> result) {
        try {
            return new ObjectMapper().readValue(
                    result.getContent().getName(),
                    StoreDto.class
            );
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
