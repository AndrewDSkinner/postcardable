package com.postcardable.postcardable.web.dto.response;

import com.postcardable.postcardable.model.PostcardType;

public class HalfsheetResponseDto extends PostcardResponseDto{
    public HalfsheetResponseDto(Long id, String length, String width, String finish, Double thickness, String corners) {
        super(PostcardType.HALFSHEET, id, length, width, finish, thickness, corners);
    }
}
