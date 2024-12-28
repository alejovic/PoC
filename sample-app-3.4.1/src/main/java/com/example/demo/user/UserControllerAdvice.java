package com.example.demo.user;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class UserControllerAdvice {

    @ExceptionHandler(UserNotFound.class)
    public ResponseEntity<UserNotFound> handleUserNotFound(UserNotFound ex, WebRequest req){
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
