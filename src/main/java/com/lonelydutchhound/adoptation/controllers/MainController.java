package com.lonelydutchhound.adoptation.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

    @GetMapping("/")
    private @ResponseBody
    String hello() {
        return "Hello";
    }
}
