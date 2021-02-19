package com.wangcr.kk.web.service.impl;

import com.fasterxml.jackson.databind.JsonNode;
import com.wangcr.kk.web.config.WxApiConfig;
import com.wangcr.kk.web.config.WxConfig;
import com.wangcr.kk.web.entity.WxAuthAccesstoken;
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
    public Map Wxlogin(String code) {
        Map map = new HashMap();
        if(StringUtils.isNotBlank(code)){
            String url = WxApiConfig.WXLOGINAPI + "?" + WxConfig.WxDevAppId.getKey() + "=" + WxConfig.WxDevAppId.getValue()
                    + "&" + WxConfig.WxDevSecret.getKey() + "=" + WxConfig.WxDevSecret.getValue()
                    + "&" + "js_code=" + code + "&grant_type=authorization_code";

            JsonNode jsonobject = restTemplate.getForObject(url, JsonNode.class);
            log.info(jsonobject.toString());
            WxAuthAccesstoken wxauth = new WxAuthAccesstoken();
            map.put("data",jsonobject);
//            if(jsonobject != null){
//                wxauth.setOpenid(jsonobject.get("openid").toString());
//                wxauth.setSessionKey(jsonobject.get("session_key").toString());
//                wxauth.setUnionid(jsonobject.get("unionid").toString());
//                log.info(wxauth.toString());
//                map.put("Auth",wxauth);
//            }else{
//                log.error("Object is null");
//            }
        }else{
            log.error("the code is null");
        }


        return map;
    }
}
