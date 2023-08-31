package com.postcardable.postcardable.service;

import com.postcardable.postcardable.model.Corners;
import com.postcardable.postcardable.model.Finish;
import com.postcardable.postcardable.model.Postcard;
import com.postcardable.postcardable.repository.PostcardRepository;
import com.postcardable.postcardable.web.dto.request.PostcardType;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostcardServiceImpl implements PostcardService{

    PostcardRepository postcardRepository;

    public PostcardServiceImpl(PostcardRepository postcardRepository) {
        this.postcardRepository = postcardRepository;
    }

    @Override
    public Postcard createPostcard(PostcardType type, Finish finish, Double thickness, Corners corners) {
        return postcardRepository.savePostcard(type, finish, thickness, corners);
    }

    @Override
    public Postcard getPostcardById(Long id) {
        return postcardRepository.getPostcardById(id);
    }

    @Override
    public List<Postcard> findPostcardsByType(PostcardType type) {
        return postcardRepository.findPostcardsByType(type);
    }
}
