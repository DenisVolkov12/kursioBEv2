package ru.kursio.application.model.exception;

/**
 * This is the wrapper to Throw custom Exceptions to use in developed try / catches
 * regarding what can happen in the logic fails and map error occurs in the code development.
 */
public class RenatQuizNotFoundException extends Exception {

    private static final long serialVersionUID = 1L;

    public RenatQuizNotFoundException() {
        super();
    }

    public RenatQuizNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public RenatQuizNotFoundException(String message) {
        super(message);
    }

    public RenatQuizNotFoundException(Throwable cause) {
        super(cause);
    }
}
