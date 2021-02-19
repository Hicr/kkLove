package com.wangcr.kk.web.controller;

import com.wangcr.kk.web.service.LoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Api("微信登陆接口")
@RestController
@RequestMapping("wx")
public class LoginController {

    @Autowired
    private LoginService login;

    @ApiOperation("登陆接口")
    @RequestMapping(value = "login", method = RequestMethod.GET)
    public Map loginController(String code){
        return login.Wxlogin(code);
    }








}
