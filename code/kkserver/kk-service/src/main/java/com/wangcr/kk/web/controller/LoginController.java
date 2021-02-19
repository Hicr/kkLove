package com.wangcr.kk.web.controller;

import com.wangcr.kk.web.service.LoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Api("微信登陆接口")
@RestController
@RequestMapping("wx/v1")
public class LoginController {

    @Autowired
    private LoginService login;

    @ApiOperation(value = "查询微信用户信息", response = Map.class)
    @RequestMapping(value = "wxuser", method = RequestMethod.GET)
    public Map loginUserInfo(@ApiParam("code") String code)throws Exception{
        return login.WxUserInfo(code);
    }


    @ApiOperation(value = "微信登陆" , response = Map.class)
    @RequestMapping(value = "login", method = RequestMethod.GET)
    public Map loginController(@ApiParam("openId") String openId){
        return null;
    }






}
