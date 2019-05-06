package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.mapper.UMapper;
import com.example.demo.service.UserService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Administrator on 2019/4/30.
 */

@RestController
public class Test {
    @Autowired
    private static UserService userService;
    public static void main(String[] args){
       // List<User> users = userService.findByNamea();
      //  System.out.println(users.size());
    }
}
