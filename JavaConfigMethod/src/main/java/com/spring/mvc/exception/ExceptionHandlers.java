package com.spring.mvc.exception;

import org.springframework.stereotype.Component;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@Component
@RestControllerAdvice
public class ExceptionHandlers {

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public String handleMissingServletRequestParameterException(MissingServletRequestParameterException e) {
        return "missing parameter " + e.getParameterName();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public String hanleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        List<ObjectError> allErrors = e.getBindingResult().getAllErrors();
        return allErrors.stream().map(objectError -> objectError.getObjectName() + objectError.getDefaultMessage()).reduce((a, b) -> {
            return a.concat(",\n").concat(b);
        }).get();
    }
}
