package com.wangcr.kk.web.entity;

import lombok.Data;

@Data
public class WxAuthAccesstoken {
    // 会话密钥
    private String sessionKey;
    // 微信用户的唯一标识
    private String openid;
    // 用户在微信开放平台的唯一标识符。本字段在满足一定条件的情况下才返回。
    private String unionid;


}
