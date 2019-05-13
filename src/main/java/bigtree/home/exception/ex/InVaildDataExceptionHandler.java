package bigtree.home.exception.ex;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.MethodArgumentNotValidException;

import bigtree.home.exception.handlers.MethodArgumentNotValidExceptionHandler;
import lombok.extern.slf4j.Slf4j;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
@Slf4j
public class InVaildDataExceptionHandler extends MethodArgumentNotValidExceptionHandler {

    @Override
    public HttpStatus getStatus(MethodArgumentNotValidException ex) {
        return HttpStatus.UNPROCESSABLE_ENTITY;
    }

    @Override
    protected int getErrorCode(MethodArgumentNotValidException ex) {
        log.info("InVaildDataExceptionHandler error details ============" + ex.getBindingResult().getFieldErrors());
        return SampleExceptionRuntimeException.VALIDATION_ERRORCODE;
    }

}
