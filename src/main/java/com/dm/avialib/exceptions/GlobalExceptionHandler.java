package com.dm.avialib.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ArticleNotFoundException.class)
    public ApiException handleArticleNotFoundException(ArticleNotFoundException ex) {
        return new ApiException(HttpStatus.NOT_FOUND,
                "Article not found",
                ZonedDateTime.now(ZoneId.of("Z")));
    }
}
