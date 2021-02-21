package com.wangcr.kk.web.controller;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@Api("微信接口")
@RestController
@RequestMapping("wx/v2")
public class WxController {


    /**
     * 查询 用户信息，登录后才能访问
     */
    @RequestMapping("/test")
    public String login() {

        return "登陆成功 允许访问";
    }


}
