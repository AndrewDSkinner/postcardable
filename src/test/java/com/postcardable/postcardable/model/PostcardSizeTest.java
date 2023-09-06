package com.postcardable.postcardable.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PostcardSizeTest {

    @Test
    void postCardSize_happyPath() {
        PostcardSize postcardSize = new PostcardSize(5.5, 8.5);

        assertEquals(5.5, postcardSize.getLength());
        assertEquals(8.5, postcardSize.getWidth());
    }

    @Test
    void testEquals() {
        PostcardSize postcardSize1 = new PostcardSize(5.5, 8.5);
        PostcardSize postcardSize2 = new PostcardSize(4.0, 6.0);
        PostcardSize postcardSize3 = new PostcardSize(5.5, 8.5);

        assertEquals(postcardSize3, postcardSize1);
        assertNotEquals(postcardSize1, postcardSize2);
        assertEquals(postcardSize3.hashCode(), postcardSize1.hashCode());
    }

    @Test
    void testToString() {
        PostcardSize postcardSize1 = new PostcardSize(5.5, 8.5);
        String expedtedString = "PostcardSize{length=5.5, width=8.5}";

        assertEquals(postcardSize1.toString(), expedtedString);
    }
}