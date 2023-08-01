package com.postcardable.postcardable.web.dto.response;

public class PostcardResponseDto {
    private String length;
    private String width;

    public PostcardResponseDto(String length, String width) {
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
