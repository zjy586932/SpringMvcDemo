package com.spring.mvc.controller;

import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class BaseController {

    private static final String HELLO = "hello";

    @RequestMapping("/hello")
    @ResponseBody
    public String hello(){
        return HELLO;
    }
}
