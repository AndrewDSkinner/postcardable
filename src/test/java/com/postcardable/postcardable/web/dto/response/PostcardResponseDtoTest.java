package com.postcardable.postcardable.web.dto.response;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PostcardResponseDtoTest {

    @Test
    void happyPath() {
        PostcardResponseDto postcardResponseDto = new HalfsheetResponseDto(1L,"5.5", "8.5", "BAMBOO", 0.025, "ROUNDED");

        assertEquals(postcardResponseDto.getLength(), "5.5");
        assertEquals(postcardResponseDto.getWidth(), "8.5");
    }
}