package com.practice.HelloWorld;

import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.HashMap;

@RestController
@RequestMapping("/view/")
public class HelloWorldController {
    public String username;
    public String password;
    public ArrayList<String> User = new ArrayList<>();
    public ArrayList<String> Password = new ArrayList<>();

    @GetMapping("display")
    public String display(){
        String str = "Hello World";
        System.out.print(str);
        return str;
    }

    @PostMapping("register")
    public String registration(@RequestBody HashMap<String,String> reg){
        username = reg.get("username");
        password = reg.get("password");
        User.add(username);
        Password.add(password);
        return "* Registration Successful *";
    }
    @GetMapping("register/{name}")
    public String register(@PathVariable String name, @RequestBody HashMap<String,String> reg){
        username = reg.get("username");
        password = reg.get("password");
        User.add(username);
        Password.add(password);
        return "Registration Successful by "+name;
    }


}

