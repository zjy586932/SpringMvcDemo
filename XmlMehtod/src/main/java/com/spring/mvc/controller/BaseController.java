package com.spring.mvc.controller;

import com.spring.mvc.entity.BusinessOrder;
import com.spring.mvc.entity.JsonParam;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RequestMapping("/api")
@RestController
public class BaseController {

    @Value("${user}")
    private String user;

    @RequestMapping("/hello")
    @ResponseBody
    public String hello(){
        return user;
    }

    @RequestMapping("/getElectronicInvoice")
    @ResponseBody
    public String getElectronicInvoice(String orderId,String processType){
        System.out.println("orderId = " + orderId);
        System.out.println("processType = " + processType);

        return "1";
    }

    @RequestMapping(value = "/testjson",method = RequestMethod.POST , consumes = {"text/plain", "application/*"})
    public void testjson(@RequestBody JsonParam jsonparam){
        System.out.println(jsonparam.toString());
    }

    /**
     * 支付之前创建订单
     * @return
     */
    @RequestMapping(value = "/{orderId}/createPayOrder.do",method = RequestMethod.POST)
    @ResponseBody
    public Map<String , String> createPayOrder(@RequestBody BusinessOrder businessOrder, @PathVariable int orderId){
        Map<String,String> resultMap = null;
        String orderSn ="";
//        orderSn = businessProcessService.createPayOrder(businessOrder,orderId);
        if(null != orderSn){
            resultMap = new HashMap<>();
            resultMap.put("orderSn",orderSn);
        }
        return resultMap;
    }

}
