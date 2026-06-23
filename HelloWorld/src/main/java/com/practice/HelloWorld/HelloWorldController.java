package com.practice.HelloWorld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/view/")
public class HelloWorldController {

    @GetMapping("display")
    public String display(){
        String str = "Hello World";
        System.out.print(str);
        return str;
    }
}

