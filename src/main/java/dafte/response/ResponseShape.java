package dafte.response;

import dafte.model.Advice;

import java.io.IOException;

public abstract class ResponseShape {

    protected String contentType;

    protected ResponseShape(String contentType) {
        this.contentType = contentType;
    }

    public abstract String createString(Advice advice) throws IOException;

    public String getContentType() {
        return contentType;
    }
}
