package com.postcardable.postcardable.web.dto.request;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = HalfsheetRequestDto.class, name = "halfsheet"),
        @JsonSubTypes.Type(value = CardSizeRequestDto.class, name = "cardsize")
    })
public abstract class PostcardRequestDto {

    private String length;
    private String width;

    private PostcardType type;

    public PostcardRequestDto() {
    }

    public PostcardRequestDto(String length, String width) {
        this.length = length;
        this.width = width;
    }

    public String getLength() {
        return length;
    }

    public String getWidth() {
        return width;
    }

    public PostcardType getType() {
        return type;
    }
}
