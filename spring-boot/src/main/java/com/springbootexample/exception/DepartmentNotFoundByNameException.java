package com.springbootexample.exception;

public class DepartmentNotFoundByNameException extends Exception {
    public DepartmentNotFoundByNameException() {
    }

    public DepartmentNotFoundByNameException(String message) {
        super(message);
    }

    public DepartmentNotFoundByNameException(String message, Throwable cause) {
        super(message, cause);
    }

    public DepartmentNotFoundByNameException(Throwable cause) {
        super(cause);
    }

    public DepartmentNotFoundByNameException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
