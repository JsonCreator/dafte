package functions;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.google.cloud.functions.HttpFunction;
import com.google.cloud.functions.HttpRequest;
import com.google.cloud.functions.HttpResponse;
import functions.factory.AdviceFactory;
import functions.factory.RequestorFactory;
import functions.model.Advice;
import functions.model.Requestor;

import java.io.BufferedWriter;
import java.io.IOException;

public class Dafte implements HttpFunction {

    private static final ObjectMapper mapper = getObjectMapper();

    /**
     * Hello DAFTE!
     */
    @Override
    public void service(HttpRequest request, HttpResponse response) throws IOException {
        Requestor requestor = RequestorFactory.fromHttpRequest(request);
        Advice advice = AdviceFactory.createAdviceFor(requestor);

        sendAdvice(response, advice);
    }


    private void sendAdvice(HttpResponse response, Advice advice) throws IOException {
        BufferedWriter writer = response.getWriter();
        String json = mapper.writeValueAsString(advice);
        writer.write(json);
    }

    private static ObjectMapper getObjectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        return mapper;
    }
}
