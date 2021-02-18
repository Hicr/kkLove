package com.wangcr.kk.web.dao;

import com.wangcr.kk.web.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao {

    public User getNameById(User user);



}
