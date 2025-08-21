package com.group.ecommerce.Exception;

import com.group.ecommerce.Dto.Base.Response;
import com.group.ecommerce.Exception.Model.DuplicateException;
import com.group.ecommerce.Exception.Model.ResourceNotFoundException;
import com.group.ecommerce.Exception.Model.UnprocessableExeception;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Response> handleResourceNotFoundException(ResourceNotFoundException ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Response.fail("404", "fail", ex.getMessage()));
    }

    @ExceptionHandler(DuplicateException.class)
    public ResponseEntity<Response> handleDuplicateException(DuplicateException ex){
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(Response.fail("409", "fail", ex.getMessage()));
    }

    @ExceptionHandler(UnprocessableExeception.class)
    public ResponseEntity<Response> handleUnprocessableExeception(UnprocessableExeception ex){
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY)
                .body(Response.fail("422", "fail", ex.getMessage()));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Response> handleException(Exception ex){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(Response.error("fail", ex.getMessage()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Response> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex){
        Map<String, String> errors = new HashMap<>();

//        {
//            "code": "400",
//                "message": "Validation failed",
//                "description": "Some fields are invalid",
//                "data": {
//            "username": "Username is required",
//                    "email": "Invalid email format",
//                    "password": "Password must be at least 6 characters"
//        },
//            "timestamp": 1692607845123
//        }

        ex.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(Response.badRequest("fail", "Some fields are invalid", errors));
    }
}
