package com.postcardable.postcardable.model;

import static com.postcardable.postcardable.model.PostcardType.HALFSHEET;

public class HalfSheet extends Postcard{

    public HalfSheet(Long id, Finish finish, Double thickness, Corners corners) {
        super(id, new PostcardDimensions(5.5, 8.5, thickness), finish, corners);
    }

    @Override
    public PostcardType getType() {
        return HALFSHEET;
    }
}
