package bigtree.home.exception.ex;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.stereotype.Component;

import bigtree.home.exception.handlers.AbstractExceptionHandler;
import lombok.extern.slf4j.Slf4j;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
@Slf4j
public class JsonNotReadableExceptionHandler extends AbstractExceptionHandler<HttpMessageNotReadableException> {

    protected JsonNotReadableExceptionHandler() {
        super(JsonNotReadableExceptionHandler.class.getSimpleName());
    }

    @Override
    protected HttpStatus getStatus(HttpMessageNotReadableException error) {
        return HttpStatus.UNPROCESSABLE_ENTITY;
    }

    @Override
    protected int getErrorCode(HttpMessageNotReadableException ex) {
        log.info("JsonNotReadableExceptionHandler error message ========== " + ex.getMessage());
        return SampleExceptionRuntimeException.VALIDATION_ERRORCODE;
    }
}
