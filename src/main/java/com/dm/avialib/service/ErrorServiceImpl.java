package com.dm.avialib.service;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Service;

@Service
public class ErrorServiceImpl implements ErrorService {
    @Override
    public String getError(HttpServletRequest request) {
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

        int statusCode = Integer.parseInt(status.toString());

        return switch (statusCode) {
            case 400 -> badRequest();
            case 403 -> noPermission();
            case 404 -> pageNotFound();
            default -> unknownError();
        };
    }

    @Override
    public String pageNotFound() {
        return "404";
    }

    @Override
    public String noPermission() {
        return "403";
    }

    @Override
    public String badRequest() {
        return "400";
    }

    @Override
    public String unknownError() {
        return "error";
    }
}
