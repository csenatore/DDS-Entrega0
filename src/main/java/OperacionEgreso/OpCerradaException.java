package OperacionEgreso;

public class OpCerradaException extends Exception {
    public OpCerradaException() {
        super();
    }

    public OpCerradaException(String message) {
        super(message);
    }

    public OpCerradaException(String message, Throwable cause) {
        super(message, cause);
    }

    public OpCerradaException(Throwable cause) {
        super(cause);
    }

    protected OpCerradaException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
