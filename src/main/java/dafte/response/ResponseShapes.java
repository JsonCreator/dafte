package dafte.response;

import com.google.common.collect.ImmutableMap;

import java.util.Optional;

public class ResponseShapes {

    private static final JsonResponse JSON = new JsonResponse();
    private static final RawResponse RAW = new RawResponse();

    private static final ImmutableMap<String, ResponseShape> RESPONSE_SHAPES = ImmutableMap.of(
            "JSON", JSON,
            "RAW", RAW);

    public static ResponseShape get(String shapeString) {
        Optional<String> shape = Optional.ofNullable(shapeString);

        return shape.map(String::toUpperCase)
                .map(RESPONSE_SHAPES::get)
                .orElse(JSON);
    }
}
