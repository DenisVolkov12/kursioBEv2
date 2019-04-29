package ru.kursio.application.model.exception;

/**
 * This is the wrapper to Throw custom Exceptions to use in developed try / catches
 * regarding what can happen in the logic fails and map error occurs in the code development.
 */
public class KursioException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public KursioException() {
        super();
    }

    public KursioException(String message, Throwable cause) {
        super(message, cause);
    }

    public KursioException(String message) {
        super(message);
    }

    public KursioException(Throwable cause) {
        super(cause);
    }
}
