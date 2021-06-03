package dafte;

import com.google.cloud.functions.HttpFunction;
import com.google.cloud.functions.HttpRequest;
import com.google.cloud.functions.HttpResponse;
import dafte.factory.AdviceFactory;
import dafte.factory.RequestorFactory;
import dafte.model.Advice;
import dafte.model.Requester;
import dafte.model.ResultShape;

import java.io.BufferedWriter;
import java.io.IOException;

public class Dafte implements HttpFunction {

    /**
     * It's DAFTE! Get your free Advice!
     */
    @Override
    public void service(HttpRequest request, HttpResponse response) throws IOException {
        Requester requester = RequestorFactory.fromHttpRequest(request);
        Advice advice = AdviceFactory.createAdviceFor(requester);
        ResultShape resultShape = ResultShape.fromRequest(request);

        sendAdvice(response, resultShape, advice);
    }


    private void sendAdvice(HttpResponse response, ResultShape resultShape, Advice advice) throws IOException {
        BufferedWriter writer = response.getWriter();
        writer.write(resultShape.buildResult(advice));
    }
}
