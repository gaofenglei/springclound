package com.gfl.controller;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;

@Component
public class MyFilter extends ZuulFilter {

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        System.out.println("无敌之神级无敌");
        return null;
    }

    /*
    filterType：返回一个字符串代表过滤器的类型，在zuul中定义了四种不同生命周期的过滤器类型，具体如下：
    pre：路由之前
    routing：路由之时
    post： 路由之后
    error：发送错误调用
    filterOrder：过滤的顺序
    shouldFilter：这里可以写逻辑判断，是否要过滤，本文true,永远过滤。
    run：过滤器的具体逻辑。可用很复杂，包括查sql，nosql去判断该请求到底有没有权限访问。
    */

}
