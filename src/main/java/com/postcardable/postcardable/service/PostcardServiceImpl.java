package com.postcardable.postcardable.service;

import com.postcardable.postcardable.model.Postcard;
import com.postcardable.postcardable.repository.PostcardRepository;
import com.postcardable.postcardable.web.dto.request.PostcardType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostcardServiceImpl implements PostcardService{

    PostcardRepository postcardRepository;
    @Autowired
    public PostcardServiceImpl(PostcardRepository postcardRepository) {
        this.postcardRepository = postcardRepository;
    }

    @Override
    public Postcard createPostcard(PostcardType type) {
        return postcardRepository.savePostcard(type);
    }

    @Override
    public Postcard getPostcardById(Long id) {
        return postcardRepository.getPostcardById(id);
    }
}
