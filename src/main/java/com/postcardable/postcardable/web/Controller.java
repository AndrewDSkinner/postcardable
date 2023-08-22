package com.postcardable.postcardable.web;

import com.postcardable.postcardable.model.Postcard;
import com.postcardable.postcardable.service.PostcardService;
import com.postcardable.postcardable.web.dto.request.PostcardRequestDto;
import com.postcardable.postcardable.web.dto.response.PostcardResponseDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.postcardable.postcardable.web.dto.request.PostcardType.CARDSIZE;
import static com.postcardable.postcardable.web.dto.request.PostcardType.HALFSHEET;

@RestController()
@RequestMapping("/postcard")
public class Controller {

    Logger logger = LoggerFactory.getLogger(getClass());

    PostcardService postcardService;

    @Autowired
    public Controller(PostcardService postcardService) {
        this.postcardService = postcardService;
    }

    @PostMapping
    public ResponseEntity<PostcardResponseDto> createPostcard(@RequestBody PostcardRequestDto postcardRequestDto) {
        logger.info("SUCCESS: length is " + postcardRequestDto.getLength() + " width is " + postcardRequestDto.getWidth());

        PostcardResponseDto responseDto = null;

        if (!ObjectUtils.isEmpty(postcardRequestDto)) {

            if (postcardRequestDto.getType() == HALFSHEET) {
                responseDto = Postcard.to(postcardService.createPostcard(HALFSHEET));
            }
            if (postcardRequestDto.getType() == CARDSIZE) {
                responseDto = Postcard.to(postcardService.createPostcard(CARDSIZE));
            }
        }

        return ResponseEntity.ok(responseDto);
    }
}
