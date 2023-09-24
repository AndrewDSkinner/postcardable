package com.postcardable.postcardable.repository;

import com.postcardable.postcardable.model.Corners;
import com.postcardable.postcardable.model.Finish;
import com.postcardable.postcardable.model.Postcard;
import com.postcardable.postcardable.model.PostcardType;

import java.util.List;

public interface PostcardRepository {
   Postcard savePostcard(PostcardType type, Finish finish, Double thickness, Corners corners);
   Postcard getPostcardById(Long id);
   List<Postcard> findPostcardsByType(PostcardType type);
}
