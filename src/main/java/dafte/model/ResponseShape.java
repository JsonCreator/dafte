package dafte.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.google.common.collect.ImmutableMap;

import java.io.IOException;
import java.util.Arrays;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public enum ResponseShape {

    JSON {
        @Override
        public String buildResult(Advice advice) throws IOException {
            return mapper.writeValueAsString(advice);
        }
    },

    RAW {
        @Override
        public String buildResult(Advice advice) throws IOException {
            return advice.getAdvice();
        }
    };

    public abstract String buildResult(Advice advice) throws IOException;

    private static final ObjectMapper mapper = getObjectMapper();

    private static final ImmutableMap<String, ResponseShape> RESULT_SHAPE_MAP =
            ImmutableMap.copyOf(
                    Arrays.stream(values())
                            .collect(Collectors.toMap(ResponseShape::name, Function.identity())));

    public static ResponseShape from(String shapeString) {
        Optional<String> shape = Optional.ofNullable(shapeString);

        return shape.map(String::toUpperCase)
                .map(RESULT_SHAPE_MAP::get)
                .orElse(JSON);
    }

    private static ObjectMapper getObjectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        return mapper;
    }
}
