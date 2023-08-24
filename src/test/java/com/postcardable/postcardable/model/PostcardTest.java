package com.postcardable.postcardable.model;

import com.postcardable.postcardable.web.dto.response.PostcardResponseDto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class PostcardTest {

    @Test
    void givenPostcardIsNull_whenToMethodExecuted_PostcardIsReturned() {
        PostcardResponseDto responseDto = Postcard.to(null);
        assertNotNull(responseDto);
    }
}