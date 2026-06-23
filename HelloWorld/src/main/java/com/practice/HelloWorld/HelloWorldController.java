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
    @PostMapping("register_error")
    public String registrationError(@RequestBody HashMap<String,String> err){
        username = err.get("username");
        password = err.get("password");
        if(User.contains(username) && Password.contains(password)) return "Already existed";
        User.add(username);
        Password.add(password);
        return "* Registration Successful *";
    }

    @PostMapping("login")
    public String login(@RequestBody HashMap<String,String> log){
        String name = log.get("username");
        String pass = log.get("password");
        if(User.contains(name) && Password.contains(pass) ) return "* Login successful *";
        else
            return "Check Your login credentials";
    }
    @GetMapping("user/{name}")
    public String User(@PathVariable String name, @RequestBody HashMap<String,String> reg){
        username = reg.get("username");
        password = reg.get("password");
        return "Registration Successful by "+name;
    }
}

