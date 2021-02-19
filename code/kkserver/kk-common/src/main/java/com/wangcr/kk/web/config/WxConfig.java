package com.wangcr.kk.web.config;

public enum WxConfig {

    WxDevAppId("appid","wx4049881a8ccb0781"),
    WxDevSecret("secret","8fb0c4b1ce86cd98c49977bdaab3514b");

    private final String key;

    private final String value;

    private WxConfig(String key,String value){
        this.key = key;
        this.value = value;
    }

    public String getKey(){
        return key;
    }
    public String getValue(){
        return value;
    }






}
