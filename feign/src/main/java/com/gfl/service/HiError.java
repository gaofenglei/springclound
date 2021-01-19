package com.gfl.service;

import org.springframework.stereotype.Component;

@Component
public class HiError implements TestService{
    @Override
    public String sayHiFromClientOne(String name) {
        return "调用接口异常,请联系管理员!";
    }
}
