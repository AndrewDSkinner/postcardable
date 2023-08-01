package com.postcardable.postcardable.web.dto.request;

public class PostcardRequestDto {
    private String length;
    private String width;

    public PostcardRequestDto(String length, String width) {
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
