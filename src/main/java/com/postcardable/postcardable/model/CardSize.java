package com.postcardable.postcardable.model;

import com.postcardable.postcardable.web.dto.request.PostcardType;

import static com.postcardable.postcardable.web.dto.request.PostcardType.CARDSIZE;

public class CardSize extends Postcard {

    public CardSize(Long id, Finish finish, Double thickness, Corners corners) {
        super(id, new PostcardSize(4.0, 6.0), finish, thickness, corners);
    }

    @Override
    public PostcardType getType() {
        return CARDSIZE;
    }
}
