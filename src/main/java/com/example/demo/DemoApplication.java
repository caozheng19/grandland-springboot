package com.example.demo;

import com.example.demo.entity.User;
import com.example.demo.mapper.UMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.util.List;

@SpringBootApplication
public class DemoApplication {
	@Autowired
    private static UMapper uMapper;
	public static void main(String[] args) {

		SpringApplication.run(DemoApplication.class, args);


	}

}
