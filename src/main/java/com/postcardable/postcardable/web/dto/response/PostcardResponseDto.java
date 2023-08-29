package com.postcardable.postcardable.web.dto.response;

import java.util.Objects;

public class PostcardResponseDto {
    private final String length;
    private final String width;
    private final String finish;
    private final Double thickness;
    private final String corners;

    public PostcardResponseDto() {
        this.length = "";
        this.width = "";
        this.finish = "";
        this.thickness = 0.0;
        this.corners = "";
    }

    public PostcardResponseDto(String length, String width, String finish, Double thickness, String corners) {
        this.length = length;
        this.width = width;
        this.finish = finish;
        this.thickness = thickness;
        this.corners = corners;
    }

    public String getLength() {
        return length;
    }

    public String getWidth() {
        return width;
    }

    public String getFinish() {
        return finish;
    }

    public Double getThickness() {
        return thickness;
    }

    public String getCorners() {
        return corners;
    }

    @Override
    public String toString() {
        return "PostcardResponseDto{" +
                "length='" + length + '\'' +
                ", width='" + width + '\'' +
                ", finish='" + finish + '\'' +
                ", thickness=" + thickness +
                ", corners='" + corners + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PostcardResponseDto that = (PostcardResponseDto) o;
        return Objects.equals(length, that.length) && Objects.equals(width, that.width) && Objects.equals(finish, that.finish) && Objects.equals(thickness, that.thickness) && Objects.equals(corners, that.corners);
    }

    @Override
    public int hashCode() {
        return Objects.hash(length, width, finish, thickness, corners);
    }
}
