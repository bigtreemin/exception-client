package bigtree.home.exception.ex;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import bigtree.home.exception.handlers.AbstractExceptionHandler;

@Component
public class SampleExceptionRuntimeExceptionHandler extends AbstractExceptionHandler<SampleExceptionRuntimeException> {

    public SampleExceptionRuntimeExceptionHandler() {
        super(SampleExceptionRuntimeException.class.getSimpleName());
    }

    @Override
    public HttpStatus getStatus(SampleExceptionRuntimeException ex) {
        HttpStatus status;
        switch (ex.getErrorCode()) {
        case SampleExceptionRuntimeException.VALIDATION_ERRORCODE:
            status = HttpStatus.PARTIAL_CONTENT;
            break;
        default:
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return status;
    }

    @Override
    protected int getErrorCode(SampleExceptionRuntimeException e) {
        return e.getErrorCode();
    }

}
