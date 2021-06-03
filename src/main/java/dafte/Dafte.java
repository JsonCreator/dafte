package dafte;

import com.google.cloud.functions.HttpFunction;
import com.google.cloud.functions.HttpRequest;
import com.google.cloud.functions.HttpResponse;
import dafte.factory.AdviceFactory;
import dafte.factory.RequestorFactory;
import dafte.model.Advice;
import dafte.model.Requester;
import dafte.model.ResultShape;
import spark.Request;
import spark.Response;

import java.io.BufferedWriter;
import java.io.IOException;

import static spark.Spark.get;

public class Dafte implements HttpFunction {

    /**
     * It's DAFTE! But it's a Spark REST Server
     */
    public static void main(String[] args) {
        // Only one route baby. This is ALL we do
        get("/", Dafte::sendAdvice);
    }

    public static String sendAdvice(Request request, Response response) throws IOException {
        Requester requester = RequestorFactory.fromRequest(request);
        Advice advice = AdviceFactory.createAdviceFor(requester);
        ResultShape resultShape = ResultShape.fromRequest(request);

        return resultShape.buildResult(advice);
    }

    /**
     * It's DAFTE! But it's a Google Cloud Function
     */
    @Override
    public void service(HttpRequest request, HttpResponse response) throws IOException {
        Requester requester = RequestorFactory.fromHttpRequest(request);
        Advice advice = AdviceFactory.createAdviceFor(requester);
        ResultShape resultShape = ResultShape.fromHttpRequest(request);

        sendAdvice(response, resultShape, advice);
    }


    private void sendAdvice(HttpResponse response, ResultShape resultShape, Advice advice) throws IOException {
        BufferedWriter writer = response.getWriter();
        writer.write(resultShape.buildResult(advice));
    }
}
