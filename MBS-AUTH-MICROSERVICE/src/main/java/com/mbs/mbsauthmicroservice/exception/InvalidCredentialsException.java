package com.mbs.mbsauthmicroservice.exception;

public class InvalidCredentialsException extends RuntimeException{
    public InvalidCredentialsException() {
        super("Email or password is incorrect");
    }
}
