package com.wangcr.kk.web.controller;


import com.wangcr.kk.web.entity.User;
import com.wangcr.kk.web.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
@Api("用户操作接口")
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation("测试接口")
    @GetMapping("hello")
    public String getUser(){
        return "hello";
    }


    @GetMapping("test")
    public String test() {
        User user_result = userService.getUserByName("wangcr");
        System.out.println("2222");
        System.out.println(user_result.toString());
        return "Hello World!";
    }



}
