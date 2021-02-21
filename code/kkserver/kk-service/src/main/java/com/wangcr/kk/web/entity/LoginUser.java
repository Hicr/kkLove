package com.wangcr.kk.web.entity;

import lombok.Data;

import java.io.Serializable;
@Data
public class LoginUser implements Serializable {
    // openid
    String id;

    String username;

    String password;



}
