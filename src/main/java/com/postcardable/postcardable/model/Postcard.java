package com.postcardable.postcardable.model;

import com.postcardable.postcardable.web.dto.request.PostcardType;
import com.postcardable.postcardable.web.dto.response.PostcardResponseDto;

public abstract class Postcard {
    private final Long id;
    private final PostcardSize size;

    private final Finish finish;

    private final Double thickness;

    private final Corners corners;

    private PostcardType type;

    public Postcard(Long id, PostcardSize size, Finish finish, Double thickness, Corners corners) {
        this.id = id;
        this.size = size;
        this.finish = finish;
        this.thickness = thickness;
        this.corners = corners;
    }

    public Long getId() {
        return id;
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
            String length = postcard.size.getLength().toString();
            String width = postcard.size.getWidth().toString();
            return new PostcardResponseDto(postcard.id, length, width, postcard.finish.toString(), postcard.thickness, postcard.corners.toString());
        }
        return new PostcardResponseDto();
    }
}
