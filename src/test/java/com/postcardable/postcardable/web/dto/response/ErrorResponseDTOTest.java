package com.postcardable.postcardable.web.dto.response;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import static org.junit.jupiter.api.Assertions.*;

class ErrorResponseDTOTest {

    @Test
    void happyPath() {
        ErrorResponseDTO errorResponseDTO = new ErrorResponseDTO(HttpStatus.BAD_REQUEST, "Invalid Parameters");

        assertEquals(HttpStatus.BAD_REQUEST, errorResponseDTO.getHttpStatus());
        assertEquals("Invalid Parameters", errorResponseDTO.getMessage());
    }

}