package com.postcardable.postcardable.service;

import com.postcardable.postcardable.model.CardSize;
import com.postcardable.postcardable.model.HalfSheet;
import com.postcardable.postcardable.model.Postcard;
import com.postcardable.postcardable.web.dto.request.PostcardRequestDto;
import com.postcardable.postcardable.web.dto.request.PostcardType;
import org.springframework.stereotype.Service;

@Service
public class PostcardServiceImpl implements PostcardService{
    @Override
    public Postcard createPostcard(PostcardRequestDto requestDto) {
       if (requestDto.getType() == PostcardType.HALFSHEET) {
           return new HalfSheet();
       }

       if (requestDto.getType() == PostcardType.CARDSIZE) {
           return new CardSize();
       }

       return null;
    }
}
