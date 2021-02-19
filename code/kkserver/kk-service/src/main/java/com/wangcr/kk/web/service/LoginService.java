package com.wangcr.kk.web.service;

import java.util.Map;

public interface LoginService {

    /**
     * 获取微信用户信息接口
     * @param code
     * @return
     */
    public Map WxUserInfo(String code) throws Exception;

    /**
     * 根据微信用户的openId来进行登陆小程序后端应用
     * @param openId
     * @return
     */
    public Map WxLogin(String openId);
}
