package com.springboot.cricapi.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class ServerException extends RuntimeException {

    private HttpStatus httpStatus ;

    public ServerException(HttpStatus httpStatus) {
        this.httpStatus = httpStatus ;
    }

    public ServerException(Exception e) {
        super(e);
    }


}
