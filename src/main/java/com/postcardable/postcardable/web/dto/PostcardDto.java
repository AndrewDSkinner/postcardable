package com.postcardable.postcardable.web.dto;

public class PostcardDto {
    private String length;
    private String width;

    public PostcardDto(String length, String width) {
        this.length = length;
        this.width = width;
    }

    public String getLength() {
        return length;
    }

    public String getWidth() {
        return width;
    }
}
