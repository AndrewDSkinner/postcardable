package com.postcardable.postcardable.model;

import com.postcardable.postcardable.web.dto.request.PostcardType;
import com.postcardable.postcardable.web.dto.response.PostcardResponseDto;

public abstract class Postcard {
    private final double length;
    private final double width;

    private PostcardType type;

    public Postcard() {
        this.length = 0.0;
        this.width = 0.0;
    }

    public Postcard(double length, double width) {
        this.length = length;
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public double getWidth() {
        return width;
    }

    public PostcardType getType() {
        return type;
    }

    public static PostcardResponseDto to(Postcard postcard) {
        if(postcard != null) {
            return new PostcardResponseDto(String.valueOf(postcard.length), String.valueOf(postcard.width));
        }
        return new PostcardResponseDto();
    }
}
