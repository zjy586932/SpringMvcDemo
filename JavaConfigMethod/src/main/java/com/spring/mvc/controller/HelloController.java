package com.spring.mvc.controller;

import com.spring.mvc.entity.Address;
import com.spring.mvc.entity.Order;
import com.spring.mvc.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HelloController {

    @Autowired
    private HelloService helloService;

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

    @GetMapping("/hi")
    @ResponseBody
    public String hi(){
        return helloService.hi();
    }

    @GetMapping("/getOrder")
    @ResponseBody
    public Order getOrder(){
        Address address = new Address();
        address.setAddressId(1);
        address.setAddressDetail("qingadoshi");
        Order order = new Order().setOrderId(1).setOrderState("11").setAddress(address);
        return order;
    }
}
