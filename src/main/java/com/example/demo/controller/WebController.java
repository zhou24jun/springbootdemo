package com.example.demo.controller;

import com.example.demo.common.ResponseBean;
import com.example.demo.common.TokenRequired;
import com.example.demo.common.UnauthorizedException;
import com.example.demo.database.UserBean;
import com.example.demo.database.UserService;
import com.example.demo.util.JWTUtil;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @className: WebController
 * @description: TODO 类描述
 * @author: junZhou
 * @date: 2020/7/10
 **/
@RestController
@Api(value = "WebController")
@Slf4j
public class WebController {

    private static final Logger LOGGER = LogManager.getLogger(WebController.class);

    private UserService userService;

    @Autowired
    public void setService(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")

    public ResponseBean login(@RequestBody UserBean user) {
        UserBean userBean = userService.getUser(user.getUsername());
        if (userBean.getPassword().equals(user.getPassword())) {
            return new ResponseBean(200, "Login success", JWTUtil.sign(user.getUsername(), user.getPassword()));
        } else {
            throw new UnauthorizedException();
        }
    }

    @GetMapping("/api/ver")
    @TokenRequired
    public ResponseBean ver(@RequestParam String username) {
        log.info(username + " invoke ver");
        return new ResponseBean(200, "yes", null);
    }

    @GetMapping("/api/ver2")
    @TokenRequired
    public ResponseBean verify(@RequestParam String username) {
        log.info(username + " invoke verify");
        return new ResponseBean(200, "yes yes", null);
    }

}
