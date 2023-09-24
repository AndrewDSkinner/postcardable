package com.postcardable.postcardable.model;

import static com.postcardable.postcardable.model.PostcardType.CARDSIZE;

public class CardSize extends Postcard {

    public CardSize(Long id, Finish finish, Double thickness, Corners corners) {
        super(id, new PostcardDimensions(4.0, 6.0, thickness), finish, corners);
    }

    @Override
    public PostcardType getType() {
        return CARDSIZE;
    }
}
