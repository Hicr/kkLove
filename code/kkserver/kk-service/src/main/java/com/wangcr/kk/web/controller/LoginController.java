package com.wangcr.kk.web.controller;

import com.wangcr.kk.common.ResultList;
import com.wangcr.kk.web.entity.LoginUser;
import com.wangcr.kk.web.service.LoginService;
import com.wangcr.kk.web.service.TokenService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;




@Slf4j
@Api("微信登陆接口")
@RestController
@RequestMapping("wx/v1")
public class LoginController {

    @Autowired
    private LoginService login;

    /**
     * 登陆接口
     * @param code
     * @return
     */
    @ApiOperation(value = "微信登陆" , response = Map.class)
    @RequestMapping(value = "login", method = RequestMethod.GET)
    public ResultList loginController(@ApiParam("code") String code) throws Exception {
        return login.WxLogin(code);
    }

    /**
     * 使用用户名密码登陆
     * @param username
     * @param password
     * @return
     */
    @ApiOperation(value = "微信登陆" , response = Map.class)
    @RequestMapping(value = "loginbyuser", method = RequestMethod.GET)
    public ResultList loginbyuserController(@ApiParam("username") String username,
                                      @ApiParam("password") String password) throws Exception {
        return login.WxloginByUser(username, password);
    }










    //START===================测试过滤器模拟方法============================================================/
    static Map<Integer, LoginUser> userMap = new HashMap<>();

    static {
        //模拟数据库
        LoginUser user1 = new LoginUser();
        user1.setUsername("1");
        user1.setId("1");
        user1.setPassword("1");
        userMap.put(1, user1);
        LoginUser user2 = new LoginUser();
        user2.setUsername("2");
        user2.setId("2");
        user2.setPassword("2");
        userMap.put(2, user2);
    }

    /**
     * 模拟用户 登录
     */
    @RequestMapping("/test/login")
    public String login(LoginUser user) {
        log.info(user.toString());
        for (LoginUser dbUser : userMap.values()) {
            if (dbUser.getUsername().equals(user.getUsername()) && dbUser.getPassword().equals(user.getPassword())) {
                log.info("登录成功！生成token！");
                String token = TokenService.createToken(dbUser);
                return token;
            }
        }
        return "";
    }

    //END==============================================================================================/


}
