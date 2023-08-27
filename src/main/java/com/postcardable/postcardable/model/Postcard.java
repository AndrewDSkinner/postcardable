package com.postcardable.postcardable.model;

import com.postcardable.postcardable.web.dto.request.PostcardType;
import com.postcardable.postcardable.web.dto.response.PostcardResponseDto;

public abstract class Postcard {
    private final PostcardSize size;

    private final Finish finish;

    private final Double thickness;

    private final Corners corners;

    private PostcardType type;

    public Postcard(PostcardSize size, Finish finish, Double thickness, Corners corners) {
        this.size = size;
        this.finish = finish;
        this.thickness = thickness;
        this.corners = corners;
    }

    public PostcardSize getSize() {
        return size;
    }

    public Finish getFinish() {
        return finish;
    }

    public Double getThickness() {
        return thickness;
    }

    public Corners getCorners() {
        return corners;
    }

    public PostcardType getType() {
        return type;
    }

    public static PostcardResponseDto to(Postcard postcard) {
        if(postcard != null) {
            return new PostcardResponseDto(String.valueOf(postcard.getSize().getLength()), String.valueOf(postcard.getSize().getWidth()));
        }
        return new PostcardResponseDto();
    }
}
