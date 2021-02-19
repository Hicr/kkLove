# 微信小程序 后端服务

## 待做TODO

// 密码加密

## 框架结构说明

- kk-api // 项目接口

- kk-common // 公共方法

- kk-service // 数据处理层

- kk-web // springboot启动

## 功能记录

- 微信小程序登陆功能
> 小程序连接中苹果和安卓据说需要配置下面的连接 待确认
> 
> server:
>
> ssl:
>
> enabled-protocols: TLSv1,TLSv1.1,TLSv1.2
>
> ciphers: TLS_ECDHE_RSA_WITAES_128_CBC_SHA256,TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA,TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA384,TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA,TLS_RSA_WITH_AES_128_CBC_SHA256,TLS_RSA_WITH_AES_128_CBC_SHA,TLS_RSA_WITH_AES_256_CBC_SHA256,TLS_RSA_WITH_AES_256_CBC_SHA

## 框架

- Maven
- springboot  
    - v2.4.2
- MyBatis
- Swagger
    - v2.9.2 
    - http://localhost:8081/swagger-ui.html
    - https://www.cnblogs.com/swzx-1213/p/12736993.html
- Lof4j2 //TODO  上线记得修改日志的路径位置
- RestFul： Springboot提供
- http连接：RestTemplate Spring提供
  - [调用微信接口](https://blog.csdn.net/u013469944/article/details/84193792)
  - [RestTemplate 调用方式](https://www.cnblogs.com/wzk-0000/p/10955406.html)
## SpringBoot 笔记

- controller层一定要在启动类的下层

## 相关地址

- http://localhost:8081/user/test

- http://localhost:8081/swagger-ui.html
- [微信小程序登陆 博文1](https://blog.csdn.net/sxl131415/article/details/80427999)
- [微信小程序登陆 博文2](https://blog.csdn.net/it_most/article/details/109696247)

## 异常代码

- 400 默认错误
- 401 权限错误
- 404 找不到