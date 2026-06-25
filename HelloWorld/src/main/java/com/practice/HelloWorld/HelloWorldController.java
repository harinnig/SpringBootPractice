package com.practice.HelloWorld;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;

@RestController
@RequestMapping("/view/")
public class HelloWorldController {

    @Autowired
    private Userdata userdata;

    @GetMapping("display")
    public String display(){
        String str = "Hello World";
        System.out.print(str);
        return str;
    }

    @PostMapping("register")
    public String registration(@RequestBody HashMap<String,String> reg){

        userdata.name = reg.get("Name");
        userdata.username = reg.get("username");
        userdata.password = reg.get("password");
        userdata.dob = reg.get("DOB");
        if(userdata.name == null || userdata.name.isBlank()) return "Please fill Name";
        if(userdata.username == null || userdata.username.isBlank()) return "Please fill Username";
        if(userdata.password == null || userdata.password.isBlank()) return "Please fill Password";
        if(userdata.dob == null || userdata.dob.isBlank()) return "Please fill DOB";
        if(userdata.User.contains(userdata.username)) return "Username already exists";
        userdata.Id++;
        userdata.Name.add(reg.get("Name"));
        userdata.User.add(reg.get("username"));
        userdata.Password.add(reg.get("password"));
        userdata.DOB.add(reg.get("DOB"));
        userdata.ID.add(userdata.Id);
        return "* Registration Successful *";
    }

    @PostMapping("login")
    public String login(@RequestBody HashMap<String,String> log){
        String Uname = log.get("username");
        String pass = log.get("password");
        int i = 0;
        while(i < userdata.User.size()){
            if(userdata.User.get(i).equals(Uname) && userdata.Password.get(i).equals(pass)) return "* Login successful *";
            i++;
        }
        return "Check Your login credentials";
    }
    @GetMapping("users")
    public String Users(@RequestBody HashMap<String,String> reg){
        userdata.username = reg.get("username");
        userdata.password = reg.get("password");
        return userdata.username;
    }

    @PutMapping("usersupdate/{id}")
    public String UsersUpdate(@PathVariable Long id, @RequestBody HashMap<String,String> upd){
        userdata.name = upd.get("Name");
        userdata.username = upd.get("username");
        userdata.password = upd.get("password");
        userdata.dob = upd.get("DOB");
        int index = userdata.User.indexOf(userdata.username);
        if(index == -1) return "User not found";
        userdata.Name.set(index, userdata.name);
        userdata.User.set(index,userdata.username);
        userdata.Password.set(index,userdata.password);
        userdata.DOB.set(index,userdata.dob);
        if(userdata.ID.contains((id))) return userdata.name;
        return "User found ID is"+ id;
    }
}

