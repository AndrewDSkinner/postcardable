package com.postcardable.postcardable.service;

import com.postcardable.postcardable.model.Corners;
import com.postcardable.postcardable.model.Finish;
import com.postcardable.postcardable.model.HalfSheet;
import com.postcardable.postcardable.model.Postcard;
import com.postcardable.postcardable.repository.PostcardRepository;
import com.postcardable.postcardable.web.dto.request.PostcardType;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.postcardable.postcardable.model.Corners.ROUNDED;
import static com.postcardable.postcardable.web.dto.request.PostcardType.HALFSHEET;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class PostcardServiceImplTest {
    private PostcardRepository postcardRepository;
    private PostcardServiceImpl postcardService;

    PostcardServiceImplTest() {
        this.postcardRepository = mock(PostcardRepository.class);
        this.postcardService = new PostcardServiceImpl(postcardRepository);
    }

    @Test
    void createPostcardHappyPath() {
        PostcardType type = HALFSHEET;
        Finish finish = Finish.LINEN;
        Double thickness = .025;
        Corners corners = ROUNDED;
        HalfSheet postcardResponse = new HalfSheet(1L, Finish.LINEN, .025, ROUNDED);
        when(postcardRepository.savePostcard(type, finish, thickness, corners)).thenReturn(postcardResponse);

        Postcard response = postcardService.createPostcard(type, finish, thickness, corners);
        assertNotNull(response);
        assertEquals(response.getType(), type);
        assertEquals(response.getFinish(), finish);
        assertEquals(response.getCorners(), corners);
        assertEquals(response.getSize().getThickness(), thickness);
    }

    @Test
    void getPostcardByIdHappyPath() {
        Finish finish = Finish.LINEN;
        Double thickness = .025;
        Corners corners = ROUNDED;
        HalfSheet halfSheet = new HalfSheet(1L, finish, thickness, corners);
        when(postcardRepository.getPostcardById(1L)).thenReturn(halfSheet);

        Postcard response = postcardService.getPostcardById(1L);

        assertEquals(response, halfSheet);
    }

    @Test
    void findPostcardsByTypeHappyPath() {
        HalfSheet halfSheet1 = new HalfSheet(1L, Finish.LINEN, 0.034, ROUNDED);
        HalfSheet halfSheet2 = new HalfSheet(2L, Finish.BAMBOO, 0.25, Corners.SQUARE);
        List<Postcard> postcards = List.of(halfSheet1, halfSheet2);
        when(postcardRepository.findPostcardsByType(HALFSHEET)).thenReturn(postcards);

        List<Postcard> responses = postcardService.findPostcardsByType(HALFSHEET);

        assertNotNull(responses);
        assertEquals(responses, postcards);
    }
}