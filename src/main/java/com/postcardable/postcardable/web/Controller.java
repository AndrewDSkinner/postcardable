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
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
        logger.info("POST /postcard {}", postcardRequestDto);

        PostcardResponseDto responseDto = null;

        Finish finish = postcardRequestDto.getFinish();
        Double thickness = postcardRequestDto.getThickness();
        Corners corners = postcardRequestDto.getCorners();

        if (!ObjectUtils.isEmpty(postcardRequestDto)) {

            if (postcardRequestDto.getType() == HALFSHEET) {
                responseDto = Postcard.to(postcardService.createPostcard(HALFSHEET, finish, thickness, corners));
            }
            if (postcardRequestDto.getType() == CARDSIZE) {
                responseDto = Postcard.to(postcardService.createPostcard(CARDSIZE, finish, thickness, corners));
            }
        }

        return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostcardResponseDto> getPostcard(@PathVariable Long id) {
        logger.info("GET /postcard/{}", id);
        PostcardResponseDto responseDto = Postcard.to(postcardService.getPostcardById(id));

        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    @GetMapping()
    public  ResponseEntity<List<PostcardResponseDto>> getPostcardsByType(@RequestParam String type) {
        logger.info("GET /postcard/ type: {}",  type);
        String value = type.toUpperCase();
        List<PostcardResponseDto> responseDtos = Postcard.buildDtos(postcardService.findPostcardsByType(PostcardType.valueOf(value)));

        return new ResponseEntity<>(responseDtos, HttpStatus.OK);
    }
}
