package ru.kursio.application.model.exception;

/**
 * This is the wrapper to Throw custom Exceptions to use in developed try / catches
 * regarding what can happen in the logic fails and map error occurs in the code development.
 */
public class IncorrectPasswordException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public IncorrectPasswordException() {
        super();
    }

    public IncorrectPasswordException(String message, Throwable cause) {
        super(message, cause);
    }

    public IncorrectPasswordException(String message) {
        super(message);
    }

    public IncorrectPasswordException(Throwable cause) {
        super(cause);
    }
}
