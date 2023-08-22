package com.postcardable.postcardable.model;

import com.postcardable.postcardable.web.dto.request.PostcardType;

import static com.postcardable.postcardable.web.dto.request.PostcardType.HALFSHEET;

public class HalfSheet extends Postcard{
    public HalfSheet() {
        super(5.5, 8.5);
    }

    @Override
    public PostcardType getType() {
        return HALFSHEET;
    }
}
