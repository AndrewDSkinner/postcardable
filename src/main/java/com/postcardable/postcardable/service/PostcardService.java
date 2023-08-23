package com.postcardable.postcardable.service;

import com.postcardable.postcardable.model.Postcard;
import com.postcardable.postcardable.web.dto.request.PostcardType;

public interface PostcardService {

    Postcard createPostcard(PostcardType type);
    Postcard getPostcardById(Long id);
}
