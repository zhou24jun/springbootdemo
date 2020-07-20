package com.example.demo.database;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@ApiModel
@NoArgsConstructor
@AllArgsConstructor

public class UserBean {

    @ApiModelProperty(value = "username",position =1)
    private String username;

    @ApiModelProperty(value = "password",position = 2)
    private String password;

    @JsonIgnore
    private String role;

    @JsonIgnore
    private String permission;

}
