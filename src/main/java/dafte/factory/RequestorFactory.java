package dafte.factory;

import com.google.cloud.functions.HttpRequest;
import dafte.model.Requestor;

import java.time.LocalDate;

public class RequestorFactory {

    private static final String NAME_QUERY_PARAM = "name";

    public static Requestor fromHttpRequest(HttpRequest request) {
        String requestorName = getNameFromRequest(request);
        LocalDate requestDate = LocalDate.now();

        return new Requestor(requestorName, requestDate);
    }

    private static String getNameFromRequest(HttpRequest request) {
        if (request.getQueryParameters().containsKey(NAME_QUERY_PARAM) &&
                !request.getQueryParameters().get(NAME_QUERY_PARAM).isEmpty()) {
            return request.getQueryParameters().get(NAME_QUERY_PARAM).get(0);
        }
        return null;
    }
}
