package com.job.micro.accounttx.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UnavailableBalanceException.class)
    public ResponseEntity<ErrorDetails> handleUnavailableBalanceException(UnavailableBalanceException exception,
                                                                        WebRequest webRequest) {
        ErrorDetails errorDetails = new ErrorDetails(
                LocalDateTime.now(),
                exception.getMessage(),
                webRequest.getDescription(false),
                "UNAVAILABLE_BALANCE_EXCEPTION");

        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }

}
