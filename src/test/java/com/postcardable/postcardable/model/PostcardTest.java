package com.postcardable.postcardable.model;

import com.postcardable.postcardable.web.dto.request.PostcardType;
import com.postcardable.postcardable.web.dto.response.PostcardResponseDto;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class PostcardTest {

    @Test
    void givenPostcardIsNull_whenToMethodExecuted_PostcardIsReturned() {
        PostcardResponseDto responseDto = Postcard.to(null);
        assertNotNull(responseDto);
    }

    @Test
    void cardSize_HappyPath() {
        CardSize cardSize = new CardSize(1L, Finish.GLOSSY, .035, Corners.SQUARE);

        assertEquals(cardSize.getType(), PostcardType.CARDSIZE);
        assertEquals(cardSize.getId(), 1L);
        assertEquals(cardSize.getFinish(), Finish.GLOSSY);
        assertEquals(cardSize.getThickness(), .035);
        assertEquals(cardSize.getCorners(), Corners.SQUARE);
    }

    @Test
    void halfSheet_HappyPath() {
        HalfSheet halfSheet = new HalfSheet(1L, Finish.PEARL, .035, Corners.SQUARE);

        assertEquals(halfSheet.getType(), PostcardType.HALFSHEET);
        assertEquals(halfSheet.getId(), 1L);
        assertEquals(halfSheet.getFinish(), Finish.PEARL);
        assertEquals(halfSheet.getThickness(), .035);
        assertEquals(halfSheet.getCorners(), Corners.SQUARE);
    }

    @Test
    void testToMethod_happyPath() {
        HalfSheet halfSheet = new HalfSheet(1L, Finish.PEARL, .035, Corners.SQUARE);

        PostcardResponseDto responseDto = Postcard.to(halfSheet);

        assertEquals(halfSheet.getId(), responseDto.getId());
        assertEquals(halfSheet.getThickness(), responseDto.getThickness());
        assertEquals(halfSheet.getCorners().toString(), responseDto.getCorners());
        assertEquals(halfSheet.getFinish().toString(), responseDto.getFinish());
    }

    @Test
    void buildDtos_happyPath() {
        HalfSheet halfSheet = new HalfSheet(1L, Finish.PEARL, .035, Corners.SQUARE);
        CardSize cardSize = new CardSize(1L, Finish.BAMBOO, .023, Corners.SQUARE);
        List<Postcard> postcards = List.of(halfSheet, cardSize);

        List<PostcardResponseDto> responseDtos = Postcard.buildDtos(postcards);
        assertNotNull(responseDtos);
        assertEquals(postcards.get(0).getId(), responseDtos.get(0).getId());
        assertEquals(postcards.get(0).getFinish().toString(), responseDtos.get(0).getFinish());
        assertEquals(postcards.get(0).getThickness(), responseDtos.get(0).getThickness());
        assertEquals(postcards.get(0).getThickness(), responseDtos.get(0).getThickness());
        assertEquals(postcards.get(0).getCorners().toString(), responseDtos.get(0).getCorners());
    }
}