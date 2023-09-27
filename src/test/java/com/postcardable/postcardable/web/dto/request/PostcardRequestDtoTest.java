package com.postcardable.postcardable.web.dto.request;

import com.postcardable.postcardable.model.Corners;
import com.postcardable.postcardable.model.Finish;
import jakarta.validation.ValidationException;
import org.junit.jupiter.api.Test;

import static com.postcardable.postcardable.model.Corners.SQUARE;
import static com.postcardable.postcardable.model.Finish.LINEN;
import static com.postcardable.postcardable.model.Finish.RECYCLED;
import static com.postcardable.postcardable.model.PostcardType.CARDSIZE;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PostcardRequestDtoTest {

    @Test
    void halfsheetRequestDto_happyPath() {
        PostcardRequestDto postcardRequestDto = new HalfsheetRequestDto(Finish.RECYCLED, .016, SQUARE);
        assertEquals(RECYCLED, postcardRequestDto.getFinish());
        assertEquals(.016, postcardRequestDto.getThickness());
        assertEquals(SQUARE, postcardRequestDto.getCorners());
    }

    @Test
    void givenThicknessIsNull_whenDtoIsConstructed_thenExceptionIsThrown() {
        Exception exception = assertThrows(ValidationException.class,() -> new CardSizeRequestDto(LINEN, null, Corners.ROUNDED));
        assertEquals("Thickness must be at least .007 inches and no more than .016 inches.", exception.getMessage());
    }

    @Test
    void cardSizeRequestDto_happyPath() {
        PostcardRequestDto postcardRequestDto = new CardSizeRequestDto(Finish.RECYCLED, .016, SQUARE);
        assertEquals(RECYCLED, postcardRequestDto.getFinish());
        assertEquals(.016, postcardRequestDto.getThickness());
        assertEquals(SQUARE, postcardRequestDto.getCorners());
        assertEquals(CARDSIZE, postcardRequestDto.getType());
    }

    @Test
    void testEquals() {
        CardSizeRequestDto cardSizeRequestDto1 = new CardSizeRequestDto(Finish.RECYCLED, .016, SQUARE);
        CardSizeRequestDto cardSizeRequestDto2 = new CardSizeRequestDto(Finish.RECYCLED, .016, SQUARE);
        HalfsheetRequestDto halfsheetRequestDto1 = new HalfsheetRequestDto(Finish.RECYCLED, .016, SQUARE);
        HalfsheetRequestDto halfsheetRequestDto2 = new HalfsheetRequestDto(Finish.RECYCLED, .016, SQUARE);

        assertEquals(halfsheetRequestDto1, halfsheetRequestDto2);
        assertEquals(halfsheetRequestDto1.hashCode(), halfsheetRequestDto2.hashCode());
        assertEquals(cardSizeRequestDto1, cardSizeRequestDto2);
        assertEquals(cardSizeRequestDto1.hashCode(), cardSizeRequestDto2.hashCode());
    }

}