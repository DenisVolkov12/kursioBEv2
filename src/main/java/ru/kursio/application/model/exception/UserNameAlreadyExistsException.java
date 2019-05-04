package ru.kursio.application.model.exception;

/**
 * This is the wrapper to Throw custom Exceptions to use in developed try / catches
 * regarding what can happen in the logic fails and map error occurs in the code development.
 */
public class UserNameAlreadyExistsException extends Exception {

    private static final long serialVersionUID = 1L;

    public UserNameAlreadyExistsException() {
        super();
    }

    public UserNameAlreadyExistsException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserNameAlreadyExistsException(String message) {
        super(message);
    }

    public UserNameAlreadyExistsException(Throwable cause) {
        super(cause);
    }
}
