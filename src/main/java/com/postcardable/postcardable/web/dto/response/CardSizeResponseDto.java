package com.postcardable.postcardable.web.dto.response;

import com.postcardable.postcardable.web.dto.request.PostcardType;

public class CardSizeResponseDto extends PostcardResponseDto{

    public CardSizeResponseDto(Long id, String length, String width, String finish, Double thickness, String corners) {
        super(PostcardType.CARDSIZE, id, length, width, finish, thickness, corners);
    }
}
