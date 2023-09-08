package com.postcardable.postcardable.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PostcardDimensionsTest {

    @Test
    void postCardSize_happyPath() {
        PostcardDimensions postcardDimensions = new PostcardDimensions(5.5, 8.5, 0.035);

        assertEquals(5.5, postcardDimensions.getLength());
        assertEquals(8.5, postcardDimensions.getWidth());
        assertEquals(.035, postcardDimensions.getThickness());
    }

    @Test
    void testEquals() {
        PostcardDimensions postcardSize1 = new PostcardDimensions(5.5, 8.5, .035);
        PostcardDimensions postcardDimensions2 = new PostcardDimensions(4.0, 6.0, .025);
        PostcardDimensions postcardDimensions3 = new PostcardDimensions(5.5, 8.5, .035);

        assertEquals(postcardDimensions3, postcardSize1);
        assertNotEquals(postcardSize1, postcardDimensions2);
        assertEquals(postcardDimensions3.hashCode(), postcardSize1.hashCode());
    }

    @Test
    void testToString() {
        PostcardDimensions postcardDimensions1 = new PostcardDimensions(5.5, 8.5, .035);
        String expectedString = "PostcardSize{length=5.5, width=8.5, thickness=0.035}";

        assertEquals(postcardDimensions1.toString(), expectedString);
    }
}