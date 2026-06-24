package com.practice.HelloWorld;

import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.HashMap;

@RestController
@RequestMapping("/view/")
public class HelloWorldController {
    public String name;
    public String username;
    public String password;
    public String dob;
    public int Id = 0;
    public ArrayList<String> Name = new ArrayList<>();
    public ArrayList<String> User = new ArrayList<>();
    public ArrayList<String> Password = new ArrayList<>();
    public ArrayList<Integer> ID = new ArrayList<>();
    public ArrayList<String> DOB = new ArrayList<>();

    @GetMapping("display")
    public String display(){
        String str = "Hello World";
        System.out.print(str);
        return str;
    }

    @PostMapping("register")
    public String registration(@RequestBody HashMap<String,String> reg){

        String name = reg.get("Name");
        String username = reg.get("username");
        String password = reg.get("password");
        String dob = reg.get("DOB");
        if(name == null || name.isBlank()) return "Please fill Name";
        if(username == null || username.isBlank()) return "Please fill Username";
        if(password == null || password.isBlank()) return "Please fill Password";
        if(dob == null || dob.isBlank()) return "Please fill DOB";
        if(User.contains(username)) return "Username already exists";
        Id++;
        Name.add(name);
        User.add(username);
        Password.add(password);
        DOB.add(dob);
        ID.add(Id);
        return "* Registration Successful *";
    }

    @PostMapping("login")
    public String login(@RequestBody HashMap<String,String> log){
        String Uname = log.get("username");
        String pass = log.get("password");
        int i = 0;
        while(i < User.size()){
            if(User.get(i).equals(Uname) && Password.get(i).equals(pass)) return "* Login successful *";
            i++;
        }
        return "Check Your login credentials";
    }
    @GetMapping("users/{id}")
    public String Users(@PathVariable String id, @RequestBody HashMap<String,String> reg){
        username = reg.get("username");
        password = reg.get("password");
        return username+" "+id;
    }

    @PutMapping("usersupdate/{id}")
    public String UsersUpdate(@PathVariable String id, @RequestBody HashMap<String,String> upd){
        name = upd.get("Name");
        username = upd.get("username");
        password = upd.get("password");
        dob = upd.get("DOB");
        int index = User.indexOf(username);
        if(index == -1) return "User not found";
        Name.set(index,name);
        User.set(index,username);
        Password.set(index,password);
        DOB.set(index,dob);
        return "Updated successfully by id"+ id;
    }
}

