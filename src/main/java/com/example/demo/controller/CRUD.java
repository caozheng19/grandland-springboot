package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Administrator on 2019/4/29.
 */
//@RestController
@Configuration
@RequestMapping(value = "/CRUD", method = { RequestMethod.GET, RequestMethod.POST })
public class CRUD {
    @RequestMapping("/ListUser")
    @ResponseBody
    public List<User> ListUser(){
        return userservice.ListUser();
    }
    //对数据库进行查找操作
    @RequestMapping("/ListUserByname")
    @ResponseBody
    public List<User> ListUserByname(String name){
        return userservice.findByName(name);
    }
    @Autowired
    private UserService userservice;
    //对数据库进行的删除操作
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String delete(int id) {
        int result = userservice.delete(id);
        if (result >= 1) {
            return "redirect:/CRUD1/listCategory";
        } else {
            return "删除失败";
        }
    }
    //对数据进行修改的操作
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(User user) {
        System.out.println("这是ID:"+user.getId());
        System.out.println("这是name:"+user.getName());
        System.out.println("这是gender:"+user.getGender());
        int result = userservice.Update(user);
        if (result >= 1) {
            return "redirect:/CRUD1/list";
        } else {
            return "修改失败";
        }
    }
    //对数据库进行增加字段操作
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public String insert(User user)
    {
        userservice.insertUser(user);
        return "redirect:/CRUD1/list";
    }


}

