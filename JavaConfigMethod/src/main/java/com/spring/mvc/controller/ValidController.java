package com.spring.mvc.controller;

import com.spring.mvc.entity.Order;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/valid")
public class ValidController {

    @GetMapping("/parameter")
    @ResponseBody
    public Integer validParameter(@RequestParam @Validated Integer a){
        return a;
    }

    @GetMapping("/parameter1")
    @ResponseBody
    public Integer validParameter1(Integer a){
        return a;
    }

    @PostMapping("/validOrder")
    @ResponseBody
    public String validOrder(@RequestBody @Valid Order order){
        return "success";
    }
}
