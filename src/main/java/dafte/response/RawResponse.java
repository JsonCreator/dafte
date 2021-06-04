package dafte.response;

import dafte.model.Advice;

import java.io.IOException;

public class RawResponse extends ResponseShape {

    private static final String RAW_CONTENT_TYPE = "text/plain";

    public RawResponse() {
        super(RAW_CONTENT_TYPE);
    }

    @Override
    public String createString(Advice advice) throws IOException {
        return advice.getAdvice();
    }
}
