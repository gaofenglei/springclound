package com.gfl.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class test {

    @Autowired
    RestTemplate restTemplate;

    @GetMapping(value = "/hi")
    @HystrixCommand(fallbackMethod="HiError")
    public String hi(String name) {
        return restTemplate.getForObject("http://SERVICE-HI/hi?name="+name,String.class);
    }


    public String HiError(String name) {
        return "调用远程接口发生了异常,请联系管理员!";
    }

}
