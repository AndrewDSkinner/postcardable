package com.postcardable.postcardable.service;

import com.postcardable.postcardable.model.Corners;
import com.postcardable.postcardable.model.Finish;
import com.postcardable.postcardable.model.Postcard;
import com.postcardable.postcardable.repository.PostcardRepository;
import com.postcardable.postcardable.model.PostcardType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostcardServiceImpl implements PostcardService{

    private final Logger logger = LoggerFactory.getLogger(getClass());

    PostcardRepository postcardRepository;

    public PostcardServiceImpl(PostcardRepository postcardRepository) {
        this.postcardRepository = postcardRepository;
    }

    @Override
    public Postcard createPostcard(PostcardType type, Finish finish, Double thickness, Corners corners) {
        logger.info("Creating postcard with type: {} finish: {} thickness: {} corners: {}",
                type, finish, thickness, corners);
        return postcardRepository.savePostcard(type, finish, thickness, corners);
    }

    @Override
    public Postcard getPostcardById(Long id) {
        logger.info("Retrieving postcard with ID: {}", id);
        return postcardRepository.getPostcardById(id);
    }

    @Override
    public List<Postcard> findPostcardsByType(PostcardType type) {
        logger.info("Retrieving postcard with TYPE: {}",  type);
        return postcardRepository.findPostcardsByType(type);
    }
}
