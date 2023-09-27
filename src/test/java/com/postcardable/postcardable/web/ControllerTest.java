package com.postcardable.postcardable.web;

import com.postcardable.postcardable.model.Corners;
import com.postcardable.postcardable.model.Finish;
import com.postcardable.postcardable.model.HalfSheet;
import com.postcardable.postcardable.service.PostcardService;
import com.postcardable.postcardable.web.dto.request.HalfsheetRequestDto;
import com.postcardable.postcardable.web.dto.request.PostcardRequestDto;
import com.postcardable.postcardable.model.PostcardType;
import com.postcardable.postcardable.web.dto.response.PostcardResponseDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@WebMvcTest(Controller.class)
class ControllerTest {

    @MockBean
    private PostcardService postcardService;
    private Controller controller;

    @BeforeEach
    void setup() {
        this.controller = new Controller(postcardService);
    }

    @Test
    void createHalfSheetHappyPath() {
        HalfSheet halfSheet = new HalfSheet(1L,Finish.BAMBOO, 0.009, Corners.ROUNDED);
        PostcardRequestDto postcardDto = new HalfsheetRequestDto(Finish.BAMBOO, 0.009, Corners.ROUNDED);
        when(postcardService.createPostcard(PostcardType.HALFSHEET, Finish.BAMBOO, 0.009, Corners.ROUNDED)).thenReturn(halfSheet);
        PostcardResponseDto responseDto = controller.createPostcard(postcardDto).getBody();
        assertNotNull(responseDto);
        assertEquals(responseDto.getFinish(), halfSheet.getFinish().toString());
    }
}