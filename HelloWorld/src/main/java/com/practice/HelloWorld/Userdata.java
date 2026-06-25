package com.practice.HelloWorld;

import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class Userdata {
    public int Id = 0;
    public String name ;
    public String username ;
    public String password ;
    public String dob ;
    public ArrayList<String> Name = new ArrayList<>();
    public ArrayList<String> User = new ArrayList<>();
    public ArrayList<String> Password = new ArrayList<>();
    public ArrayList<Integer> ID = new ArrayList<>();
    public ArrayList<String> DOB = new ArrayList<>();
}