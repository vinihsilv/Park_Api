package com.vinivhs.demo_park_api.Exception;

public class UsernameUniqueViolationException extends RuntimeException{

    public UsernameUniqueViolationException(String message) {
        super(message);
    }
}
