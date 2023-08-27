package com.postcardable.postcardable.model;

import com.postcardable.postcardable.web.dto.request.PostcardType;

import static com.postcardable.postcardable.web.dto.request.PostcardType.HALFSHEET;

public class HalfSheet extends Postcard{

    public HalfSheet( Finish finish, Double thickness, Corners corners) {
        super(new PostcardSize(5.5, 8.5), finish, thickness, corners);
    }

    @Override
    public PostcardType getType() {
        return HALFSHEET;
    }
}
