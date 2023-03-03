package com.springbootexample.exception;

import com.springbootexample.entity.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice // this s a specialization of the @Component annotation which allows to handle exceptions across the whole application in one global handling component.
@ResponseStatus
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(DepartmentNotFoundByIDException.class)
    public ResponseEntity<ErrorMessage> departmentNotFoundByIDException(DepartmentNotFoundByIDException exception, WebRequest request) {
        ErrorMessage message = new ErrorMessage(HttpStatus.NOT_FOUND, exception.getMessage());
        return ResponseEntity.status(message.getStatus()).body(message);
    }

    @ExceptionHandler(DepartmentNotFoundByNameException.class)
    public ResponseEntity<ErrorMessage> departmentNotFoundByNameException(DepartmentNotFoundByNameException exception, WebRequest request) {
        ErrorMessage message = new ErrorMessage(HttpStatus.NOT_FOUND, exception.getMessage());
        return ResponseEntity.status(message.getStatus()).body(message);
    }
}
