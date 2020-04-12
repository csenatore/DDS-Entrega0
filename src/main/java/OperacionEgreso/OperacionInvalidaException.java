package OperacionEgreso;

public class OperacionInvalidaException extends Exception {
    public OperacionInvalidaException() {
        super();
    }

    public OperacionInvalidaException(String message) {
        super(message);
    }

    public OperacionInvalidaException(String message, Throwable cause) {
        super(message, cause);
    }

    public OperacionInvalidaException(Throwable cause) {
        super(cause);
    }

    protected OperacionInvalidaException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
