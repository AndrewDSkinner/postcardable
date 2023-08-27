package com.postcardable.postcardable.model;

import java.util.Objects;

public class PostcardSize {
    private final Double length;
    private final Double width;

    public PostcardSize(Double length, Double width) {
        this.length = length;
        this.width = width;
    }

    public Double getLength() {
        return length;
    }

    public Double getWidth() {
        return width;
    }

    @Override
    public String toString() {
        return "PostcardSize{" +
                "length=" + length +
                ", width=" + width +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PostcardSize that = (PostcardSize) o;
        return Objects.equals(length, that.length) && Objects.equals(width, that.width);
    }

    @Override
    public int hashCode() {
        return Objects.hash(length, width);
    }
}
