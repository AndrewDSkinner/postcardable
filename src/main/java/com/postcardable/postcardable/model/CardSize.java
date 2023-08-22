package com.postcardable.postcardable.model;

import com.postcardable.postcardable.web.dto.request.PostcardType;

import static com.postcardable.postcardable.web.dto.request.PostcardType.CARDSIZE;

public class CardSize extends Postcard {

    public CardSize() {
        super(4.0, 6.0);
    }

    @Override
    public PostcardType getType() {
        return CARDSIZE;
    }
}
