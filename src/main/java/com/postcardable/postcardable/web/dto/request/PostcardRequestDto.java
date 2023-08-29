package com.postcardable.postcardable.web.dto.request;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.postcardable.postcardable.model.Corners;
import com.postcardable.postcardable.model.Finish;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = HalfsheetRequestDto.class, name = "halfsheet"),
        @JsonSubTypes.Type(value = CardSizeRequestDto.class, name = "cardsize")
    })
public abstract class PostcardRequestDto {
    private Finish finish;
    private Double thickness;
    private  Corners corners;

    private PostcardType type;

    public PostcardRequestDto() {
    }

    public PostcardRequestDto(Finish finish, Double thickness, Corners corners, PostcardType type) {
        this.finish = finish;
        this.thickness = thickness;
        this.corners = corners;
        this.type = type;
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
}
