package com.chan.sherlock.exception;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ControllerErrorHandler {

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<?> handlerCustomException(CustomException customException){
        //kreira error details na osnovu exception polja
        ErrorDetails errorDetails=new ErrorDetails(customException.getErrorCode(),customException.getMessage(), Instant.now());
        //vraca detail i status iz exception
        return new ResponseEntity<>(errorDetails,customException.getHttpStatus());
    }
}
