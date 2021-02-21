package com.wangcr.kk.web;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * @author wangcr
 * @date 2021-02-14
 */
@SpringBootApplication
@ServletComponentScan(basePackages = "com.wangcr.kk.web.filter")
public class KKWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(KKWebApplication.class, args);
    }

}
