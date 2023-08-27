package com.postcardable.postcardable.web;

import com.postcardable.postcardable.model.Postcard;
import com.postcardable.postcardable.service.PostcardService;
import com.postcardable.postcardable.web.dto.request.PostcardRequestDto;
import com.postcardable.postcardable.web.dto.response.PostcardResponseDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import static com.postcardable.postcardable.web.dto.request.PostcardType.CARDSIZE;
import static com.postcardable.postcardable.web.dto.request.PostcardType.HALFSHEET;

@RestController()
@RequestMapping("/postcard")
public class Controller {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    private final PostcardService postcardService;
    
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

        return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostcardResponseDto> getPostcard(@PathVariable Long id) {

        PostcardResponseDto responseDto = Postcard.to(postcardService.getPostcardById(id));

        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }
}
