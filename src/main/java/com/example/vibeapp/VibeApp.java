package com.example.vibeapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import org.mybatis.spring.annotation.MapperScan;

@SpringBootApplication(exclude = {org.mybatis.spring.boot.autoconfigure.MybatisAutoConfiguration.class})
public class VibeApp {
    public static void main(String[] args) {
        SpringApplication.run(VibeApp.class, args);
    }
}
