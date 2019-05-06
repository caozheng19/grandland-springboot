package com.example.demo.mapper;

import com.example.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * Created by Administrator on 2019/4/29.
 */
@Mapper
@Controller
public interface UserMapper {

        List<User> findUserByName(String name);
        public List<User> ListUser();
        public int insertUser(User user);
        public int delete(int id);
        public int Update(User user);

}
