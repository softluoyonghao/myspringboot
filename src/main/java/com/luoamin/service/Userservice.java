package com.luoamin.service;

import com.luoamin.model.Users;
import org.apache.ibatis.annotations.Param;

/**
 * Created by 22931 on 2020/2/16.
 */
public interface Userservice {
    int insertSelective(Users record);
    Users findByUsernameAndPasswd(@Param("passwd")String passwd, @Param("username")String username);
}
