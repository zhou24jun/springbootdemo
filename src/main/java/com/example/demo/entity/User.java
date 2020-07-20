package com.example.demo.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;

import java.io.Serializable;

/**
 * @className: User
 * @description: User
 * @author: junZhou
 * @date: 2020/7/2
 **/
@ApiModel
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value="用户名",required=true)
    private String username;


    @ApiModelProperty(value="密码",required=true)
    private String password;


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}
