package com.postcardable.postcardable.web.dto.request;

import com.postcardable.postcardable.model.Corners;
import com.postcardable.postcardable.model.Finish;
import com.postcardable.postcardable.model.PostcardType;

import static com.postcardable.postcardable.model.PostcardType.HALFSHEET;

public class HalfsheetRequestDto extends PostcardRequestDto{

    public HalfsheetRequestDto(Finish finish, Double thickness, Corners corners) {
        super(finish, thickness, corners);
    }

    @Override
    public PostcardType getType() {
        return HALFSHEET;
    }
}
