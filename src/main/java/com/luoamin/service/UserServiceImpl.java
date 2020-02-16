package com.luoamin.service;

import com.luoamin.dao.UsersMapper;
import com.luoamin.model.Users;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by 22931 on 2020/2/16.
 */
@Service
public class UserServiceImpl implements Userservice {
    @Resource
    private UsersMapper usersMapper;

    @Override
    @Transactional
    public int insertSelective(Users record) {
        int num=usersMapper.insertSelective(record);
        int flag=10/0;
        int num2=usersMapper.insertSelective(record);
        return num2;
    }

    @Override
    public Users findByUsernameAndPasswd(@Param("passwd") String passwd, @Param("username") String username) {
        return null;
    }
}
