package com.postcardable.postcardable.web.dto.response;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import static org.junit.jupiter.api.Assertions.*;

class ErrorResponseDTOTest {

    @Test
    void happyPath() {
        ErrorResponseDTO errorResponseDTO = new ErrorResponseDTO(String.valueOf(HttpStatus.BAD_REQUEST.value()), "Invalid Parameters");

        assertEquals(String.valueOf(HttpStatus.BAD_REQUEST.value()), errorResponseDTO.getHttpStatus());
        assertEquals("Invalid Parameters", errorResponseDTO.getMessage());
    }

}