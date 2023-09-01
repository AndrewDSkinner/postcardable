package com.postcardable.postcardable.web.dto.request;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.postcardable.postcardable.model.Corners;
import com.postcardable.postcardable.model.Finish;

import javax.xml.bind.ValidationException;

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

    public PostcardRequestDto(Finish finish, Double thickness, Corners corners) {
        validateProperties(finish, thickness, corners);
        this.finish = finish;
        this.thickness = thickness;
        this.corners = corners;
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

    private void validateProperties(Finish finish, Double thickness, Corners corners) {
        if (finish == null || thickness == null ||
                corners == null)
            try {
                throw new ValidationException("Finish, thickness, corners, and type properties are required");
            } catch (ValidationException e) {
                throw new RuntimeException(e);
            }

    }
}
