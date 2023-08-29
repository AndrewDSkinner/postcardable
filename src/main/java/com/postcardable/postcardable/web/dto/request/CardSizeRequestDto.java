package com.postcardable.postcardable.web.dto.request;

import com.postcardable.postcardable.model.Corners;
import com.postcardable.postcardable.model.Finish;

import static com.postcardable.postcardable.web.dto.request.PostcardType.CARDSIZE;

public class CardSizeRequestDto extends PostcardRequestDto{

    public CardSizeRequestDto() {

    }

    public CardSizeRequestDto(Finish finish, Double thickness, Corners corners, PostcardType type) {
        super(finish, thickness, corners, type);
    }

    @Override
    public PostcardType getType() {
        return CARDSIZE;
    }
}
