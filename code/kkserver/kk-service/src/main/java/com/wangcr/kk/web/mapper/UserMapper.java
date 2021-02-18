package com.wangcr.kk.web.mapper;

import com.wangcr.kk.web.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    @Select("select * from kk_user where username = #{username}")
    User getUserByName(@Param("username") String username);


}
