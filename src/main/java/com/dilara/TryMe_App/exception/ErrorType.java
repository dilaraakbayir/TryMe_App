package com.dilara.TryMe_App.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
@Getter
@AllArgsConstructor
public enum ErrorType {
    INTERNAL_ERROR_SERVER(1000,"Server error.", HttpStatus.INTERNAL_SERVER_ERROR),
    BAD_REQUEST(1001,"Parameters error.",HttpStatus.BAD_REQUEST),
    USER_ALREADY_EXISTS(2000,"User already exists.",HttpStatus.BAD_REQUEST),
    USER_NOT_FOUND(2001,"This user not found.",HttpStatus.NOT_FOUND),
    LOGIN_ERROR(2002,"Password or username is not correct.",HttpStatus.BAD_REQUEST);

    private  int code;
    private String message;
    HttpStatus httpStatus;
}
