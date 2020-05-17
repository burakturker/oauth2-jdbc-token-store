package com.example.authorization.test;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
public class TestController {

    @PostMapping
    public String register() {

        return "Hello World";
    }

    @GetMapping
    public String getsasd() {

        return "Hello World";
    }

}
