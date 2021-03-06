package com.wangcr.kk.web.controller;

import com.wangcr.kk.common.ResultList;
import com.wangcr.kk.util.ResultListUtil;
import com.wangcr.kk.web.entity.User;
import com.wangcr.kk.web.service.LoginService;
import com.wangcr.kk.web.service.UserService;
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
@Api("微信接口")
@RestController
@RequestMapping("wx/v2")
public class WxController {

    @Autowired
    private LoginService login;

    /**
     * 查询 用户信息，登录后才能访问
     */
    @RequestMapping("/test")
    public String login() {

        return "登陆成功 允许访问";
    }

    /**
     * 查询微信用户信息
     * @param code
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "查询微信用户信息", response = Map.class)
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public ResultList loginUserInfo(@ApiParam("code") String code)throws Exception{
        return login.WxUserInfo(code);
    }

    @Autowired
    private UserService userService;

    @ApiOperation(value = "根据openid查询用户信息", response = ResultList.class)
    @RequestMapping(value = "/user/byopenid" , method = RequestMethod.GET)
    public ResultList getUserByOpenIdController(@ApiParam("openid") String openid) {
        User user = userService.getUserByOpenIdSerivce(openid);
        return ResultListUtil.success(user);

    }

    @ApiOperation(value = "根据openid查询是否存在用户", response = ResultList.class)
    @RequestMapping(value = "/user/count", method = RequestMethod.GET)
    public ResultList isExistUserByOpenId(@ApiParam("openid") String openid){
        Integer count = userService.isExistUserService(openid);
        Map map = new HashMap();
        map.put("isExist",count);
        return ResultListUtil.success(map);
    }
}
