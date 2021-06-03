package dafte;

import com.google.cloud.functions.HttpFunction;
import com.google.cloud.functions.HttpRequest;
import com.google.cloud.functions.HttpResponse;
import dafte.factory.AdviceFactory;
import dafte.factory.RequestorFactory;
import dafte.model.Advice;
import dafte.model.DafteRequest;
import dafte.model.Requester;
import dafte.model.ResultShape;
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
        get("/", Dafte::getAdviceForSpark);
    }

    /**
     * It's DAFTE! But as a Google Cloud Function
     */
    @Override
    public void service(HttpRequest request, HttpResponse response) throws IOException {
        DafteRequest dafteRequest = new DafteRequest(request);

        BufferedWriter writer = response.getWriter();
        writer.write(getAdvice(dafteRequest));
    }

    protected static String getAdvice(DafteRequest dafteRequest) throws IOException {
        Requester requester = RequestorFactory.fromRequest(dafteRequest);
        ResultShape resultShape = ResultShape.fromRequest(dafteRequest);
        Advice advice = AdviceFactory.createAdviceFor(requester);

        return resultShape.buildResult(advice);
    }

    private static String getAdviceForSpark(Request request, Response response) throws IOException {
        DafteRequest dafteRequest = new DafteRequest(request);
        return getAdvice(dafteRequest);
    }
}
