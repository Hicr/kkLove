package com.wangcr.kk.web.controller;


import com.wangcr.kk.common.ResultList;
import com.wangcr.kk.util.ResultListUtil;
import com.wangcr.kk.web.entity.User;
import com.wangcr.kk.web.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

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
        User user_result = userService.getUserByNameService("wangcr");
        System.out.println("2222");
        System.out.println(user_result.toString());
        return "Hello World!";
    }

    @ApiOperation(value = "根据openid查询用户信息", response = ResultList.class)
    @RequestMapping(value = "/openid" , method = RequestMethod.GET)
    public ResultList getUserByOpenIdController(@ApiParam("openid") String openid) {
        User user = userService.getUserByOpenIdSerivce(openid);
        return ResultListUtil.success(user);

    }

    @ApiOperation(value = "根据openid查询是否存在用户", response = ResultList.class)
    @RequestMapping(value = "/count")
    public ResultList isExistUserByOpenId(@ApiParam("openid") String openid){
        Integer count = userService.isExistUserService(openid);
        Map map = new HashMap();
        map.put("isExist",count);
        return ResultListUtil.success(map);
    }

}
