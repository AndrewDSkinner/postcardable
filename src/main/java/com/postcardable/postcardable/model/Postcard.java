package com.postcardable.postcardable.model;

import com.postcardable.postcardable.web.dto.request.PostcardType;
import com.postcardable.postcardable.web.dto.response.CardSizeResponseDto;
import com.postcardable.postcardable.web.dto.response.HalfsheetResponseDto;
import com.postcardable.postcardable.web.dto.response.PostcardResponseDto;

import java.util.List;
import java.util.stream.Collectors;

public abstract class Postcard {
    private final Long id;
    private final PostcardDimensions size;

    private final Finish finish;

    private final Corners corners;

    private PostcardType type;

    public Postcard(Long id, PostcardDimensions size, Finish finish, Corners corners) {
        this.id = id;
        this.size = size;
        this.finish = finish;
        this.corners = corners;
    }

    public Long getId() {
        return id;
    }

    public PostcardDimensions getSize() {
        return size;
    }

    public Finish getFinish() {
        return finish;
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

            switch (postcard.getType()) {
                case HALFSHEET:
                    return new HalfsheetResponseDto(postcard.id, length, width, postcard.finish.toString(), postcard.size.getThickness(), postcard.corners.toString());
                case CARDSIZE:
                    return new CardSizeResponseDto(postcard.id, length, width, postcard.finish.toString(), postcard.size.getThickness(), postcard.corners.toString());
                default:
                    throw new IllegalArgumentException("Unknown postcard type: " + postcard.getType());
            }
        }
        throw new IllegalArgumentException("Unknown postcard type");
    }

    public static List<PostcardResponseDto> buildDtos(List<Postcard> postcards) {
        return postcards.stream()
                .map(Postcard::to)
                .collect(Collectors.toList());
    }
}
