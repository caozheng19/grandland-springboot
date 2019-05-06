package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.mapper.UMapper;
import com.example.demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2019/4/29.
 */
@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UMapper uMapper;
    public List<User> findByName(String name) {
        return uMapper.findUserByName(name);
    }
    public User insertUser(User user) { uMapper.insertUser(user);return user;}
    public List<User> ListUser(){
        return  uMapper.ListUser();
    }
    public int Update(User user){
        return uMapper.Update(user);
    }
    public int delete(int id){
        return uMapper.delete(id);
    }

}

