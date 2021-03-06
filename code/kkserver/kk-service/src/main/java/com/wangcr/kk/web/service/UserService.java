package com.wangcr.kk.web.service;

import com.wangcr.kk.web.entity.User;

public interface UserService {

    /**
     * 根据用户名查询用户信息
     * @param username
     * @return
     */
    public User getUserByNameService(String username);

    /**
     * 根据openid查询用户信息
     * @param openid
     * @return
     */
    public User getUserByOpenIdSerivce(String openid);

    /**
     * 查询当前是否存在openid的用户
     * @param openid
     * @return
     */
    public Integer isExistUserService(String openid);

    /**
     * 根据用户名密码查询用户信息（登陆）
     * @param username
     * @param password
     * @return
     */
    public User getUserByUserPwdService(String username, String password);


}
