package dafte.model;

import com.google.cloud.functions.HttpRequest;
import spark.Request;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DafteRequest {

    private final Requester requester;

    private final ResponseShape shape;

    public DafteRequest(Request request) {
        this(convertQueryParamMap(request.queryMap().toMap()));
    }

    public DafteRequest(HttpRequest request) {
        this(request.getQueryParameters());
    }

    private DafteRequest(Map<String, List<String>> queryParameterMap) {
        String requesterName = QueryParam.NAME.getOneFrom(queryParameterMap);
        String shapeString = QueryParam.SHAPE.getOneFrom(queryParameterMap);

        requester = new Requester(requesterName);
        shape = ResponseShape.from(shapeString);
    }

    public Requester getRequester() {
        return requester;
    }

    public ResponseShape getShape() {
        return shape;
    }

    private static Map<String, List<String>> convertQueryParamMap(Map<String, String[]> queryParamMap) {
        Map<String, List<String>> convertedMap = new HashMap<>();
        for (Map.Entry<String, String[]> entry : queryParamMap.entrySet()) {
            convertedMap.put(entry.getKey(), Arrays.asList(entry.getValue()));
        }
        return convertedMap;
    }
}
