package com.wangcr.kk.web.service;

import com.wangcr.kk.common.ResultList;

import java.util.Map;

public interface LoginService {

    /**
     * 获取微信用户信息接口
     * @param code
     * @return
     */
    public ResultList WxUserInfo(String code) throws Exception;

    /**
     * 根据微信用户的openId来进行登陆小程序后端应用
     * @param code
     * @return
     */
    public ResultList WxLogin(String code) throws Exception;

    /**
     * 使用用户名密码登陆
     * @param username
     * @param password
     * @return
     * @throws Exception
     */
    public ResultList WxloginByUser(String username, String password) throws Exception;


}
