package com.dm.avialib.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import java.time.ZoneId;
import java.time.ZonedDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ArticleNotFoundException.class)
    public ApiException handleArticleNotFoundException(ArticleNotFoundException ex) {
        return new ApiException(HttpStatus.NOT_FOUND,
                ex.getMessage(),
                ZonedDateTime.now(ZoneId.of("Z")));
    }
}
