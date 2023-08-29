package com.postcardable.postcardable.service;

import com.postcardable.postcardable.model.Corners;
import com.postcardable.postcardable.model.Finish;
import com.postcardable.postcardable.model.Postcard;
import com.postcardable.postcardable.web.dto.request.PostcardType;

public interface PostcardService {

    Postcard createPostcard(PostcardType type, Finish finish, Double thickness, Corners corners);
    Postcard getPostcardById(Long id);
}
