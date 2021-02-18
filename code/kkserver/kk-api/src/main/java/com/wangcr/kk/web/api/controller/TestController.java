package com.wangcr.kk.web.api.controller;
//import com.wangcr.kk.web.entity.User;
//import com.wangcr.kk.web.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("demo")
public class TestController {
    @GetMapping("test")
    public String test() {
        return "Hello World!";
    }


//    @Autowired
//    private UserService userService;
//
//    @GetMapping("hello")
////    @ResponseBody
//    public String getUser(){
//        User user = new User();
//        user.setUsername("wangcr");
//        User user_result = userService.getNameById(user);
//        return user_result.toString();
//    }
}
