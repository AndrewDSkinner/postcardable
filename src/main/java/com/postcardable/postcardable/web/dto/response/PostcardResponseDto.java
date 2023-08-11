package com.postcardable.postcardable.web.dto.response;

import java.util.Objects;

public class PostcardResponseDto {
    private final String length;
    private final String width;

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

    @Override
    public String toString() {
        return "PostcardResponseDto{" +
                "length='" + length + '\'' +
                ", width='" + width + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PostcardResponseDto that = (PostcardResponseDto) o;
        return Objects.equals(length, that.length) && Objects.equals(width, that.width);
    }

    @Override
    public int hashCode() {
        return Objects.hash(length, width);
    }
}
