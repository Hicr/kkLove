package com.wangcr.kk.web.service.impl;

import com.wangcr.kk.web.dao.UserDao;
import com.wangcr.kk.web.entity.User;
import com.wangcr.kk.web.mapper.UserMapper;
import com.wangcr.kk.web.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author wangcr
 */
@Service
public class UserServiceImpl implements UserService {

    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(UserServiceImpl.class);
    @Autowired
    private UserMapper userMapper;


    @Override
    public User getUserByNameService(String username){
        log.info("查询用户信息getUserByNameService");
        return userMapper.getUserByName(username);
    }

    @Override
    public User getUserByOpenIdSerivce(String openid) {
        if(StringUtils.isNotBlank(openid)){
            log.info("查询用户信息getUserByOpenIdSerivce");
            return userMapper.getUserByOpenId(openid);
        }else {
            log.error("查询用户信息getUserByOpenIdSerivce:openid is null");
            return null;
        }
    }

    @Override
    public Integer isExistUserService(String openid) {
        if (StringUtils.isNotBlank(openid)) {
            log.info("查询用户信息isExistUserService");
            return userMapper.isExistUser(openid);
        }else {
            log.error("查询用户信息getUserByOpenIdSerivce:openid is null");
            return null;
        }
    }

    @Override
    public User getUserByUserPwdService(String username, String password) {
        if(StringUtils.isNotBlank(username) && StringUtils.isNotBlank(password)){
            log.info("开始查询用户并匹配");
            return userMapper.getUserByUserPwd(username, password);
        }else{
            log.error("获取用户失败, 用户名或密码缺失");
            return null;
        }

    }


}
