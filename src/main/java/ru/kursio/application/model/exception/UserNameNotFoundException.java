package ru.kursio.application.model.exception;

/**
 * This is the wrapper to Throw custom Exceptions to use in developed try / catches
 * regarding what can happen in the logic fails and map error occurs in the code development.
 */
public class UserNameNotFoundException extends Exception {

    private static final long serialVersionUID = 1L;

    public UserNameNotFoundException() {
        super();
    }

    public UserNameNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserNameNotFoundException(String message) {
        super(message);
    }

    public UserNameNotFoundException(Throwable cause) {
        super(cause);
    }
}
