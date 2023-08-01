package com.postcardable.postcardable.model;

import com.postcardable.postcardable.web.dto.response.PostcardResponseDto;

public abstract class Postcard {
    double length;
    double width;

    public Postcard() {}

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

    public static PostcardResponseDto to(Postcard postcard) {
       return new PostcardResponseDto(String.valueOf(postcard.length), String.valueOf(postcard.width));
    }
}
