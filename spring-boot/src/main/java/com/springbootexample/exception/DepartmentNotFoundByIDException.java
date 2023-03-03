package com.springbootexample.exception;

public class DepartmentNotFoundByIDException extends Exception {
    public DepartmentNotFoundByIDException() {
        super();
    }

    public DepartmentNotFoundByIDException(String message) {
        super(message);
    }

    public DepartmentNotFoundByIDException(String message, Throwable cause) {
        super(message, cause);
    }

    public DepartmentNotFoundByIDException(Throwable cause) {
        super(cause);
    }

    protected DepartmentNotFoundByIDException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
