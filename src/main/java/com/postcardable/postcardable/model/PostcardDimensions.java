package com.postcardable.postcardable.model;

import java.util.Objects;

public class PostcardDimensions {
    private final Double length;
    private final Double width;
    private final Double thickness;

    public PostcardDimensions(Double length, Double width, Double thickness) {
        this.length = length;
        this.width = width;
        this.thickness = thickness;
    }

    public Double getLength() {
        return length;
    }

    public Double getWidth() {
        return width;
    }

    public Double getThickness() {
        return thickness;
    }

    @Override
    public String toString() {
        return "PostcardSize{" +
                "length=" + length +
                ", width=" + width +
                ", thickness=" + thickness +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PostcardDimensions that = (PostcardDimensions) o;
        return Objects.equals(length, that.length) && Objects.equals(width, that.width) && Objects.equals(thickness, that.thickness);
    }

    @Override
    public int hashCode() {
        return Objects.hash(length, width, thickness);
    }
}
