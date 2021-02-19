package com.wangcr.kk.web.service.impl;

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
    public Map WxUserInfo(String code) throws Exception{
        Map map = new HashMap();
        if(StringUtils.isNotBlank(code)){
            String url = WxApiConfig.WXLOGINAPI + "?" + WxConfig.WxDevAppId.getKey() + "=" + WxConfig.WxDevAppId.getValue()
                    + "&" + WxConfig.WxDevSecret.getKey() + "=" + WxConfig.WxDevSecret.getValue()
                    + "&" + "js_code=" + code + "&grant_type=authorization_code";

            Map userinfo = restTemplate.getForObject(url, HashMap.class);
            log.info(userinfo.toString());
            if(userinfo.containsKey("errcode")){
                throw new Exception("获取微信openId失败==========//code:"+code+"//errcode："+(int)userinfo.get("errcode")+"//errmsg"+(String)userinfo.get("errmsg")+"========================");
            }else{
                map = userinfo;
                map.put("statusCode",200);
            }
        }else{
            log.error("the code is null");
            throw new Exception("The code is null");
        }
        return map;
    }

    @Override
    public Map WxLogin(String openId) {
        return null;
    }
}
