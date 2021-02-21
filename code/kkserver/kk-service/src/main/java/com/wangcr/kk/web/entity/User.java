package com.wangcr.kk.web.entity;

import lombok.Data;

@Data
public class User {

    private Integer id;

    private String username;

    private String password;

    private String openid;

    private String createdate;

    private String updatedate;

    private String sessionkey;

}
