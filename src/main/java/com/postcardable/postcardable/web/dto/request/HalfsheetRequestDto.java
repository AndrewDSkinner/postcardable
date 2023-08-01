package com.postcardable.postcardable.web.dto.request;

import static com.postcardable.postcardable.web.dto.request.PostcardType.HALFSHEET;

public class HalfsheetRequestDto extends PostcardRequestDto{

    public HalfsheetRequestDto() {
    }

    public HalfsheetRequestDto(String length, String width) {
        super("5.5", "8.5");
    }

    @Override
    public PostcardType getType() {
        return HALFSHEET;
    }
}
