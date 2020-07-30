package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @className: IndexController
 * @description:
 * @author: junZhou
 * @date: 2020/7/22
 **/
@RestController
public class IndexController {

    @RequestMapping("/index")
    public String sayHi(){
        return "hei boy";
    }
}
