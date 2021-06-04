package dafte;

import com.google.cloud.functions.HttpFunction;
import com.google.cloud.functions.HttpRequest;
import com.google.cloud.functions.HttpResponse;
import dafte.factory.AdviceFactory;
import dafte.model.Advice;
import dafte.model.DafteRequest;
import spark.Request;
import spark.Response;

import java.io.BufferedWriter;
import java.io.IOException;

import static spark.Spark.get;

public class Dafte implements HttpFunction {

    /**
     * It's DAFTE! But as a Spark REST Server
     */
    public static void main(String[] args) {
        // Only one route baby. This is ALL we do
        get("/", Dafte::routeGetAdvice);
    }

    /**
     * It's DAFTE! But as a Google Cloud Function
     */
    @Override
    public void service(HttpRequest request, HttpResponse response) throws IOException {
        DafteRequest dafteRequest = new DafteRequest(request);

        BufferedWriter writer = response.getWriter();
        response.setContentType(dafteRequest.getShape().getContentType());
        writer.write(getAdvice(dafteRequest));
    }

    private static String routeGetAdvice(Request request, Response response) throws IOException {
        DafteRequest dafteRequest = new DafteRequest(request);
        response.header("Content-Type", dafteRequest.getShape().getContentType());
        return getAdvice(dafteRequest);
    }

    protected static String getAdvice(DafteRequest dafteRequest) throws IOException {
        Advice advice = AdviceFactory.createAdviceFor(dafteRequest.getRequester());
        return dafteRequest.getShape().createString(advice);
    }
}
