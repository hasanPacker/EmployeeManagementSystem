package com.nisum.employeemanagementsystem.Custom.EmployeeException;

import com.nisum.employeemanagementsystem.Model.GenericResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@ControllerAdvice
public class ExceptionHandling extends ResponseEntityExceptionHandler {
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllExceptions(Exception ex) {
        String errorMessage = ex.getLocalizedMessage();

        if(errorMessage == null)
            errorMessage = ex.toString();

        GenericResponse exceptionResponse =
                new GenericResponse();
        exceptionResponse.setStatus(false);
        exceptionResponse.setMessage(errorMessage);

        return new ResponseEntity(exceptionResponse, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(EmployeeException.class)
    public final ResponseEntity<Object> handleEmployeeExceptions(EmployeeException ex) {
        String errorMessage = ex.getLocalizedMessage();

        if (errorMessage == null)
            errorMessage = ex.toString();

        GenericResponse exceptionResponse =
                new GenericResponse();
        exceptionResponse.setStatus(false);
        exceptionResponse.setMessage(errorMessage);

        return new ResponseEntity(exceptionResponse, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers, HttpStatus status, WebRequest request) {
        StringBuilder errorMessage = new StringBuilder("");
        int count = ex.getBindingResult().getFieldErrors().size();
        for (int i=0; i < count;i++) {

            errorMessage.append(ex.getBindingResult().getFieldErrors().get(i).getDefaultMessage());

            if(i  != count-1)
                errorMessage.append(", ");
        }

        //String errorMessage = ex.getBindingResult().getFieldErrors().get(0).getDefaultMessage();
        List<String> validationList = ex.getBindingResult().getFieldErrors().stream().map(fieldError->fieldError.getDefaultMessage()).collect(Collectors.toList());
         GenericResponse exceptionResponse =
                new GenericResponse();
        exceptionResponse.setStatus(false);
        exceptionResponse.setMessage(errorMessage.toString());
        return new ResponseEntity<>(exceptionResponse, status);
    }
}
