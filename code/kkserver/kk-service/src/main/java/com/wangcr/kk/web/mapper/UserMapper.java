package com.wangcr.kk.web.mapper;

import com.wangcr.kk.web.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    /**
     * 根据用户名查询用户信息
     * @param username
     * @return
     */
    @Select("select * from kk_user where username = #{username}")
    User getUserByName(@Param("username") String username);

    /**
     * 根据openid查询用户信息
     * @param openid
     * @return
     */
    @Select("select * from kk_user where openid = #{openid}")
    User getUserByOpenId(@Param("openid") String openid);

    /**
     * 查询当前是否存在openid的用户
     * @param openid
     * @return
     */
    @Select("select count(1) from kk_user where openid = #{openid}")
    Integer isExistUser(@Param("openid") String openid);

    /**
     * 根据用户名密码登陆（查询用户）
     * @param username
     * @param password
     * @return
     */
    @Select("select * from kk_user where username = #{username} and password = #{password}")
    User getUserByUserPwd(@Param("username") String username, @Param("password") String password);

//    @Insert("Insert into kk_user () values ()")
//    User RegisterUserMapper(@Param("username") String username, @Param("password") String password);
}