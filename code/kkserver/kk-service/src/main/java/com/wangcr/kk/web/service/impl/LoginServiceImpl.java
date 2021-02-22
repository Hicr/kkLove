package com.wangcr.kk.web.service.impl;

import com.wangcr.kk.common.ResultList;
import com.wangcr.kk.util.ResultListUtil;
import com.wangcr.kk.web.config.WxApiConfig;
import com.wangcr.kk.web.config.WxConfig;
import com.wangcr.kk.web.entity.LoginUser;
import com.wangcr.kk.web.entity.User;
import com.wangcr.kk.web.service.LoginService;
import com.wangcr.kk.web.service.TokenService;
import com.wangcr.kk.web.service.UserService;
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
    @Autowired
    private UserService userService;
    @Autowired
    private TokenService tokenService;
    @Override
    public ResultList WxUserInfo(String code) throws Exception{
        Map map = new HashMap();
        map = getWxUserInfo(code);
        return ResultListUtil.success(map);
    }

    // TODO 完成根据code进行登陆功能
    @Override
    public ResultList WxLogin(String code) throws Exception{
        ResultList result = new ResultList();
        // 1. 根据code获取微信用户的openId及sessionId
        Map WxUserInfo = new HashMap();
        WxUserInfo = getWxUserInfo(code);
        String session_key = WxUserInfo.get("session_key").toString();
        String openid = WxUserInfo.get("openid").toString();
        // 2. 对openid与用户进行绑定 先根据openid来查询数据库中是否有该数据，有进行登陆匹配，无则注册用户，默认密码000000
        // 2.1. 先根据openid来查询是否存在用户
        // 2.2. 有则进行登陆 无则进行注册
        // 3. 生成SessionId返回小程序
        Integer count = userService.isExistUserService(openid);
        if(count == 1){
            // 查询用户并进行登陆
            User user = userService.getUserByOpenIdSerivce(openid);
            // TODO 暂未确定该session_key是否怎么持久化
            user.setSessionkey(session_key);
            LoginUser loginUser = new LoginUser();
            loginUser.setUsername(user.getUsername());
            loginUser.setId(user.getOpenid());
            String token = TokenService.createToken(loginUser);
            Map map = new HashMap();
            map.put("user",user);
            map.put("token",token);
            result = ResultListUtil.success(map);
        }else{
            // 不存在，进行注册
            log.info("当前用户不存在 count："+count);
        }
        return result;
    }

    // TODO 完成根据用户名密码登陆功能
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
