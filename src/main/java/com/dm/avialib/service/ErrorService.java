package com.dm.avialib.service;

import jakarta.servlet.http.HttpServletRequest;

public interface ErrorService {
    String getError(HttpServletRequest request);

    String pageNotFound();

    String noPermission();

    String badRequest();

    String unknownError();

}
