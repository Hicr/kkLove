package com.wangcr.kk.web.service.impl;

import com.wangcr.kk.web.dao.UserDao;
import com.wangcr.kk.web.entity.User;
import com.wangcr.kk.web.mapper.UserMapper;
import com.wangcr.kk.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(UserServiceImpl.class);
    @Autowired
    private UserMapper userMapper;



    public User getUserByName(String username){
        log.info("触发logger");
        return userMapper.getUserByName(username);
    }
}
