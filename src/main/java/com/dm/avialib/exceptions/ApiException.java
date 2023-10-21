package com.dm.avialib.exceptions;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

@Data
public class ApiException {
    private HttpStatus httpStatus;
    private String message;
    private ZonedDateTime timeStamp;

    public ApiException(HttpStatus httpStatus, String message, ZonedDateTime timeStamp) {
        this.httpStatus = httpStatus;
        this.message = message;
        this.timeStamp = timeStamp;
    }
}


