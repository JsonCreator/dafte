package dafte.response;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import dafte.model.Advice;

import java.io.IOException;

public class JsonResponse extends ResponseShape {

    private static final String JSON_CONTENT_TYPE = "application/json";

    private static final ObjectMapper MAPPER = getObjectMapper();

    public JsonResponse() {
        super(JSON_CONTENT_TYPE);
    }

    @Override
    public String createString(Advice advice) throws IOException {
        return MAPPER.writeValueAsString(advice);
    }

    private static ObjectMapper getObjectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        return mapper;
    }
}
