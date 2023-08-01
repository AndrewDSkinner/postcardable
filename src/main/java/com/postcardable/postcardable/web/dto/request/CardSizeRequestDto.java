package com.postcardable.postcardable.web.dto.request;

import static com.postcardable.postcardable.web.dto.request.PostcardType.CARDSIZE;

public class CardSizeRequestDto extends PostcardRequestDto{

    public CardSizeRequestDto() {

    }

    public CardSizeRequestDto(String length, String width) {
        super("4.0", "6.0");
    }

    @Override
    public PostcardType getType() {
        return CARDSIZE;
    }
}
