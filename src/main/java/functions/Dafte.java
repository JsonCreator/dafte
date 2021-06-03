package functions;

import com.google.cloud.functions.HttpFunction;
import com.google.cloud.functions.HttpRequest;
import com.google.cloud.functions.HttpResponse;
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

        BufferedWriter writer = response.getWriter();
        writer.write("Daily Advice For The Engineer");
    }
}
