package kim.zhyun.studyredis.dto;

import java.util.Map;

public record TestDto (
        String name,
        Integer postcode,
        String route
) {
    public static TestDto of (String name, Integer postcode, String route) {
        return new TestDto(name, postcode, route);
    }


    public Map<byte[], byte[]> getByteMap() {
        return Map.of(
                "name".getBytes(),      name().getBytes(),
                "postcode".getBytes(),  String.valueOf(postcode()).getBytes(),
                "route".getBytes(),     route().getBytes()
        );
    }
}
