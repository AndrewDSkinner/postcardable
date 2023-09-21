package com.postcardable.postcardable.web.dto.response;

import org.springframework.http.HttpStatus;

public class ErrorResponseDTO {
    private final HttpStatus httpStatus;
    private final String message;

    public ErrorResponseDTO(HttpStatus httpStatus, String message) {
        this.httpStatus = httpStatus;
        this.message = message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public String getMessage() {
        return message;
    }
}
