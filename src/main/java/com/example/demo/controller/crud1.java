package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Administrator on 2019/4/29.
 */
//@Controller
@Configuration
@RequestMapping(value = "/CRUD1", method = { RequestMethod.GET, RequestMethod.POST })
public class crud1 {
    @Autowired
    private UserService userservice;

    @RequestMapping(value="/a",method = RequestMethod.GET)
    public ModelAndView list(Model model) {
        model.addAttribute("userList",userservice.ListUser());
        model.addAttribute("title", "用户管理");
        return new ModelAndView("index","userModel",model);
    }

    @RequestMapping("/delete/{id}")
    public ModelAndView deleteUser(@PathVariable("id") int id) {

        userservice.delete(id);
        return new ModelAndView("redirect:/CRUD1/list");
    }
    @RequestMapping(value="/form",method=RequestMethod.POST)
    public ModelAndView createForm(Model model) {
        model.addAttribute("user",new User());
        model.addAttribute("title", "创建用户");
        return new ModelAndView("form","userModel",model);
    }

    @RequestMapping("/modify/{name}")
    public ModelAndView modifyUser(@PathVariable("name") String name,Model model) {
        model.addAttribute("user",userservice.findByName(name).get(0));

        model.addAttribute("title", "修改用户");
        return new ModelAndView("modify","userModel",model);
    }

    //测试分页
    @RequestMapping("/listCategory")
    public String listCategory(Model m,
                               @RequestParam(value = "start",defaultValue = "0")int start,
                               @RequestParam(value = "size",defaultValue = "5")int size){
//        List<User> cs = userservice.ListUser();
//        // 将查询的数据以分页的形式展示
//        PageHelper.startPage(start,size,"id desc");// 还可以指定排序规则
//        PageInfo<User> page = new PageInfo<>(cs);
//        m.addAttribute("page",page);

        PageHelper.startPage(start, size); //开始起始页
        List<User> blogList =userservice.ListUser();; // 获取数据
        PageInfo<User> p = new PageInfo<User>(blogList); // 实例化PageInfo

       // m.addAttribute("blogList", blogList);
        m.addAttribute("page", p); // 设置属性到前端页面

        return "listCategory";
    }

    @RequestMapping(value = "/list")
    public String list(Model model, @RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "5") Integer pageSize) {

        //引入分页查询，使用PageHelper分页功能在查询之前传入当前页，然后多少记录
        PageHelper.startPage(pageNum, pageSize);
        //startPage后紧跟的这个查询就是分页查询
        List<User> users = userservice.ListUser();
        //使用PageInfo包装查询结果，只需要将pageInfo交给页面就可以
        PageInfo pageInfo = new PageInfo<User>(users, 5);

        model.addAttribute("pageInfo", pageInfo);

        //获得当前页
        model.addAttribute("pageNum", pageInfo.getPageNum());
        //获得一页显示的条数
        model.addAttribute("pageSize", pageInfo.getPageSize());
        //是否是第一页
        model.addAttribute("isFirstPage", pageInfo.isIsFirstPage());
        //获得总页数
        model.addAttribute("totalPages", pageInfo.getPages());
        //是否是最后一页
        model.addAttribute("isLastPage", pageInfo.isIsLastPage());
        return "list";
    }

}
