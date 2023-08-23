package com.postcardable.postcardable.repository;

import com.postcardable.postcardable.model.Postcard;
import com.postcardable.postcardable.web.dto.request.PostcardType;

public interface PostcardRepository {
   Postcard savePostcard(PostcardType type);
   Postcard getPostcardById(Long id);
}
