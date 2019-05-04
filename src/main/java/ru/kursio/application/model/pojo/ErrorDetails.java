package ru.kursio.application.model.pojo;

import ru.kursio.application.constants.Constants;

import java.util.Map;

public class ErrorDetails {
    private int errorCode;
    private String errorDescription;

    public ErrorDetails(String constantErrorString) {
        Map errorsMap = Constants.ERRORS_MAP;
        this.errorCode = (Integer) errorsMap.get(constantErrorString);
        this.errorDescription = constantErrorString;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorDescription() {
        return errorDescription;
    }

    public void setErrorDescription(String errorDescription) {
        this.errorDescription = errorDescription;
    }
}
