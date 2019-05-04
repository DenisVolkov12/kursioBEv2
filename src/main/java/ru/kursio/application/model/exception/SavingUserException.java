package ru.kursio.application.model.exception;

/**
 * This is the wrapper to Throw custom Exceptions to use in developed try / catches
 * regarding what can happen in the logic fails and map error occurs in the code development.
 */
public class SavingUserException extends Exception {

    private static final long serialVersionUID = 1L;

    public SavingUserException() {
        super();
    }

    public SavingUserException(String message, Throwable cause) {
        super(message, cause);
    }

    public SavingUserException(String message) {
        super(message);
    }

    public SavingUserException(Throwable cause) {
        super(cause);
    }
}
