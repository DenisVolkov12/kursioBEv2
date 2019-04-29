package ru.kursio.application.model.pojo;

import org.springframework.http.HttpStatus;

public class ErrorDetails {
    private String details;
    private HttpStatus httpStatus;

    public ErrorDetails(String details, HttpStatus httpStatus) {
        this.details = details;
        this.httpStatus = httpStatus;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }
}
