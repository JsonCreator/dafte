package dafte.factory;

import com.google.cloud.functions.HttpRequest;
import dafte.model.Requester;
import dafte.util.QueryParamUtils;
import dafte.util.QueryParamUtils.QueryParam;
import spark.Request;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RequestorFactory {

    private static final String NAME_QUERY_PARAM = "name";

    public static Requester fromHttpRequest(HttpRequest request) {
        String requesterName = QueryParamUtils.extractSingleParam(QueryParam.NAME, request);
        LocalDate requestDate = LocalDate.now();

        return new Requester(requesterName, requestDate);
    }

    public static Requester fromRequest(Request request) {
        String requesterName = QueryParamUtils.extractSingleParam(QueryParam.NAME, request);
        LocalDate requestDate = LocalDate.now();

        return new Requester(requesterName, requestDate);
    }

    private static String getNameFromRequest(HttpRequest request) {
        if (request.getQueryParameters().containsKey(NAME_QUERY_PARAM) &&
                !request.getQueryParameters().get(NAME_QUERY_PARAM).isEmpty()) {
            return request.getQueryParameters().get(NAME_QUERY_PARAM).get(0);
        }
        return null;
    }
}
