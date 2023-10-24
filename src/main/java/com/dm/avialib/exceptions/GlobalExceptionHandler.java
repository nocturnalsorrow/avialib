package com.dm.avialib.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = {ArticleNotFoundException.class, ArticleBadRequestException.class})
    protected ResponseEntity<Object> handleArticleNotFoundException(RuntimeException ex, WebRequest request) {
        String bodyOfResponse = "Article not found";
        return handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

    @ExceptionHandler(value = ArticleBadRequestException.class)
    protected ResponseEntity<Object> handleBadRequestException(RuntimeException ex, WebRequest request) {
        String bodyOfResponse = "Article not found (Bad Request)";
        return handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }
}
