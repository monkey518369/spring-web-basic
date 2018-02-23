package com.monkey.test.spring.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("test")
public class Test {

    @RequestMapping("index")
    public String index(){
        System.out.print("=====");
        return "index";
    }
}
