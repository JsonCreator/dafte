package dafte.factory;

import dafte.model.DafteRequest;
import dafte.model.Requester;

import java.time.LocalDate;

public class RequestorFactory {

    public static Requester fromRequest(DafteRequest request) {
        String requesterName = request.getOneParamValue(DafteRequest.QueryParam.NAME);
        LocalDate requestDate = LocalDate.now();

        return new Requester(requesterName, requestDate);
    }
}
