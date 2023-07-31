package com.postcardable.postcardable.web;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("/postcard")
public class Controller {

    @PostMapping
    void createPostcard(@RequestParam String length, @RequestParam String width) {
        System.out.println("length is " + length + " width is " + width);
    }
}
