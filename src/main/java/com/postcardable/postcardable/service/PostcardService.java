package com.postcardable.postcardable.service;

import com.postcardable.postcardable.model.Postcard;
import com.postcardable.postcardable.web.dto.request.PostcardRequestDto;

public interface PostcardService {

    Postcard createPostcard(PostcardRequestDto requestDto);
}
