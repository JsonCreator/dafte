package dafte.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.google.cloud.functions.HttpRequest;
import com.google.common.collect.ImmutableMap;
import dafte.util.QueryParamUtils;
import dafte.util.QueryParamUtils.QueryParam;
import spark.Request;

import java.io.IOException;
import java.util.Arrays;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public enum ResultShape {

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

    private static final ObjectMapper mapper = getObjectMapper();

    public abstract String buildResult(Advice advice) throws IOException;

    private static final ImmutableMap<String, ResultShape> RESULT_SHAPE_MAP =
            ImmutableMap.copyOf(
                    Arrays.stream(values())
                            .collect(Collectors.toMap(ResultShape::name, Function.identity())));

    public static ResultShape fromRequest(Request request) {
        Optional<String> paramString = Optional.ofNullable(
                QueryParamUtils.extractSingleParam(QueryParam.SHAPE, request));

        return  paramString.map(String::toUpperCase)
                .map(RESULT_SHAPE_MAP::get)
                .orElse(JSON);
    }

    public static ResultShape fromHttpRequest(HttpRequest request) {
        Optional<String> paramString = Optional.ofNullable(
                QueryParamUtils.extractSingleParam(QueryParam.SHAPE, request));

        return  paramString.map(String::toUpperCase)
                .map(RESULT_SHAPE_MAP::get)
                .orElse(JSON);
    }

    private static ObjectMapper getObjectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        return mapper;
    }
}
