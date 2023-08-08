package kim.zhyun.studyredis.dto;

public record TestDto (
        String name,
        Integer postcode,
        String route
) {
    public static TestDto of (String name, Integer postcode, String route) {
        return new TestDto(name, postcode, route);
    }
}
