package functions;

import com.google.cloud.functions.HttpFunction;
import com.google.cloud.functions.HttpRequest;
import com.google.cloud.functions.HttpResponse;
import functions.factory.AdviceFactory;
import functions.factory.RandomFactory;
import functions.factory.RequestorFactory;
import functions.model.Requestor;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Random;

public class Dafte implements HttpFunction {

    /**
     * Hello DAFTE!
     */
    @Override
    public void service(HttpRequest request, HttpResponse response) throws IOException {
        Requestor requestor = RequestorFactory.fromHttpRequest(request);
        Random seededRandomizer = RandomFactory.forRequestor(requestor);
        String advice = AdviceFactory.generateAdvice(seededRandomizer);

        sendAdvice(response, advice);
    }

    
    private void sendAdvice(HttpResponse response, String advice) throws IOException {
        BufferedWriter writer = response.getWriter();
        writer.write(advice);
    }
}
