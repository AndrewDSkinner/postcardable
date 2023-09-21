package com.postcardable.postcardable.web;

import com.postcardable.postcardable.model.Corners;
import com.postcardable.postcardable.model.Finish;
import com.postcardable.postcardable.model.Postcard;
import com.postcardable.postcardable.service.PostcardService;
import com.postcardable.postcardable.web.dto.request.PostcardRequestDto;
import com.postcardable.postcardable.web.dto.request.PostcardType;
import com.postcardable.postcardable.web.dto.response.PostcardResponseDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
        logger.info("POST /postcard {}", postcardRequestDto);

        PostcardResponseDto responseDto;

        Finish finish = postcardRequestDto.getFinish();
        Double thickness = postcardRequestDto.getThickness();
        Corners corners = postcardRequestDto.getCorners();

        responseDto = Postcard.to(postcardService.createPostcard(postcardRequestDto.getType(), finish, thickness, corners));

        return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostcardResponseDto> getPostcard(@PathVariable Long id) {
        logger.info("GET /postcard/{}", id);
        PostcardResponseDto responseDto = Postcard.to(postcardService.getPostcardById(id));

        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    @GetMapping()
    public  ResponseEntity<List<PostcardResponseDto>> findPostcardsByType(@RequestParam String type) {
        logger.info("GET /postcard/ type: {}",  type);
        String value = type.toUpperCase();
        List<PostcardResponseDto> responseDtos = Postcard.buildDtos(postcardService.findPostcardsByType(PostcardType.valueOf(value)));

        return new ResponseEntity<>(responseDtos, HttpStatus.OK);
    }
}
