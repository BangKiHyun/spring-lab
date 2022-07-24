package com.lab.springlab.validation.error;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ExceptionController {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, ErrorResponse>> handelValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, ErrorResponse> errorMap = new HashMap<>();
        ex.getBindingResult().getAllErrors()
                .forEach(e -> errorMap.put(((FieldError) e).getField(), makeErrorResponse(e.getCode(), e.getDefaultMessage())));
        return ResponseEntity.badRequest()
                .body(errorMap);
    }

    private ErrorResponse makeErrorResponse(String validationCode, String detail) {
        ErrorCode errorCode = ErrorCode.findByValidationCode(validationCode);
        return new ErrorResponse(errorCode.getCode(), errorCode.getDescription(), detail);
    }
}
