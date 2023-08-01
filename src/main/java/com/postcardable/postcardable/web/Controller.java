package com.postcardable.postcardable.web;

import com.postcardable.postcardable.web.dto.PostcardDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/postcard")
public class Controller {

    @PostMapping
    public void createPostcard(@RequestBody PostcardDto postcardDto) {
        System.out.println("length is " + postcardDto.getLength() + " width is " + postcardDto.getWidth());


    }
}
