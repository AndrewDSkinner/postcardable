package com.postcardable.postcardable.web.dto.response;

import java.util.Objects;

public class ErrorResponseDTO {
    private final String httpStatus;
    private final String message;

    public ErrorResponseDTO(String httpStatus, String message) {
        this.httpStatus = httpStatus;
        this.message = message;
    }

    public String getHttpStatus() {
        return httpStatus;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ErrorResponseDTO that = (ErrorResponseDTO) o;
        return Objects.equals(httpStatus, that.httpStatus) && Objects.equals(message, that.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(httpStatus, message);
    }

    @Override
    public String toString() {
        return "ErrorResponseDTO{" +
                "httpStatus='" + httpStatus + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
