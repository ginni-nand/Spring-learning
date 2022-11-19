package com.example.demo.user.exception;


public class NoSuchUserFound extends RuntimeException {
    public NoSuchUserFound(String errorMessage) {
        super(errorMessage);
    }
}
