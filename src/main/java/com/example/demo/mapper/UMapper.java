package com.example.demo.mapper;

import com.example.demo.entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * Created by Administrator on 2019/4/30.
 */
@Mapper
@Controller
public interface UMapper {
    @Select(" SELECT * FROM user where name=#{name}")
    List<User> findUserByName(String name);
    @Select("SELECT * FROM user")
    public List<User> ListUser();
    @Insert("INSERT INTO user(id,name,gender,password,number) " +
            "        VALUES (#{id},#{name, jdbcType=VARCHAR},#{gender,jdbcType=VARCHAR},#{password, jdbcType=VARCHAR},#{number} )")
    public int insertUser(User user);
    @Delete("delete from user where id=#{id}")
    public int delete(int id);
    @Update(" update user set user.name=#{name},user.password=#{password},user.gender=#{gender} where user.id=#{id}")
    public int Update(User user);
}
