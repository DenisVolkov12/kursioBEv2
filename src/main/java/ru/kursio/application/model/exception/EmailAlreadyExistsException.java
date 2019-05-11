package ru.kursio.application.model.exception;

/**
 * This is the wrapper to Throw custom Exceptions to use in developed try / catches
 * regarding what can happen in the logic fails and map error occurs in the code development.
 */
public class EmailAlreadyExistsException extends Exception {

    private static final long serialVersionUID = 1L;

    public EmailAlreadyExistsException() {
        super();
    }

    public EmailAlreadyExistsException(String message, Throwable cause) {
        super(message, cause);
    }

    public EmailAlreadyExistsException(String message) {
        super(message);
    }

    public EmailAlreadyExistsException(Throwable cause) {
        super(cause);
    }
}
