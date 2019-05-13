package bigtree.home.exception.ex;

import lombok.Getter;

public class SampleExceptionRuntimeException extends RuntimeException {

    private static final long serialVersionUID = -6248223087190040161L;

    public static final int VALIDATION_ERRORCODE = 8888;

    @Getter
    private int errorCode = 0;

    public SampleExceptionRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }

    public SampleExceptionRuntimeException(int errorCode, String message, Throwable cause) {
        super(message, cause);
        this.errorCode = errorCode;
    }
}
