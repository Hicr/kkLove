package com.wangcr.kk.web.service.impl;

import com.wangcr.kk.common.ResultList;
import com.wangcr.kk.util.ResultListUtil;
import com.wangcr.kk.web.config.WxApiConfig;
import com.wangcr.kk.web.config.WxConfig;
import com.wangcr.kk.web.service.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;
@Slf4j
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public ResultList WxUserInfo(String code) throws Exception{
        Map map = new HashMap();
        map = getWxUserInfo(code);

        return ResultListUtil.success(map);
    }

    @Override
    public ResultList WxLogin(String code) throws Exception{
        // 1. 根据code获取微信用户的openId及sessionId
        Map WxUserInfo = new HashMap();
        WxUserInfo = getWxUserInfo(code);
        String session_key = WxUserInfo.get("session_key").toString();
        String openid = WxUserInfo.get("openid").toString();
        // 2. 对openid与用户进行绑定 先根据openid来查询数据库中是否有该数据，有进行登陆匹配，无则注册用户，默认密码000000

        // 3. 生成SessionId返回小程序





        return null;
    }

    @Override
    public ResultList WxloginByUser(String username, String password) throws Exception {
        return null;
    }


    /**
     * 查询wx用户的后台信息
     * @param code
     * @return
     * @throws Exception
     */
    public Map getWxUserInfo(String code) throws Exception{
        if(StringUtils.isNotBlank(code)){
            String url = WxApiConfig.WXLOGINAPI + "?" + WxConfig.WxDevAppId.getKey() + "=" + WxConfig.WxDevAppId.getValue()
                    + "&" + WxConfig.WxDevSecret.getKey() + "=" + WxConfig.WxDevSecret.getValue()
                    + "&" + "js_code=" + code + "&grant_type=authorization_code";

            Map userinfo = restTemplate.getForObject(url, HashMap.class);
            log.info(userinfo.toString());
            if(userinfo.containsKey("errcode")){
                throw new Exception("获取微信openId失败==========//code:"+code+"//errcode："+(int)userinfo.get("errcode")+"//errmsg"+(String)userinfo.get("errmsg")+"========================");
            }else{
                return userinfo;
            }
        }else{
            log.error("the code is null");
            throw new Exception("The code is null");
        }
    }
}
