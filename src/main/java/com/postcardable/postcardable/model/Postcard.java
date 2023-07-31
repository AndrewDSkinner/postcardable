package com.postcardable.postcardable.model;

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
}
