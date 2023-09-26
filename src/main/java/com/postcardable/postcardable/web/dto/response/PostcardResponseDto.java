package com.postcardable.postcardable.web.dto.response;

import com.postcardable.postcardable.model.PostcardType;

import java.util.Objects;

public abstract class PostcardResponseDto {
    private final PostcardType type;
    private final Long id;
    private final String length;
    private final String width;
    private final String finish;
    private final Double thickness;
    private final String corners;

    public PostcardResponseDto(PostcardType type,Long id, String length, String width, String finish, Double thickness, String corners) {
        this.type = type;
        this.id = id;
        this.length = length;
        this.width = width;
        this.finish = finish;
        this.thickness = thickness;
        this.corners = corners;
    }

    public Long getId() {
        return id;
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
                "type=" + type +
                ", id=" + id +
                ", length='" + length + '\'' +
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
        return type == that.type && Objects.equals(id, that.id) && Objects.equals(length, that.length) && Objects.equals(width, that.width) && Objects.equals(finish, that.finish) && Objects.equals(thickness, that.thickness) && Objects.equals(corners, that.corners);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, id, length, width, finish, thickness, corners);
    }
}
