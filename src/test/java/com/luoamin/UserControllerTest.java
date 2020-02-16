package com.luoamin;

import com.luoamin.dao.UsersMapper;
import com.luoamin.model.Users;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.net.URL;


/**
 * Created by 22931 on 2020/2/16.
 * 测试的时候最好指定测试的启动类，如果启动类有多个，又不指定启动类，系统不知道启动那个类
 * spring-boot-starter-test尽量使用Junit4的版本，即2.0.0.RELEASE就会默认使用这个版本
 * spring-boot-starter-test如果不设置版本的时候回自动使用Junit5，但是idea版本要2019年的
 * 版本才可以使用，所以会报NoSuchMethod的问题
 *
 */
@SpringBootTest(classes = Example.class)
@RunWith(SpringRunner.class)
public class UserControllerTest {

    /**
     * 测试加载class类时出现NoSuchMethod问题方法排查
     * 打印出现包冲突的类路径，看到底是那个包出现版本冲突
     * UserControllerTest为当前所要执行的类
     * @param args
     */
    public static void main(String[] args) {
        URL urlOfClass = UserControllerTest.class.getClassLoader().getResource("org/junit/platform/commons/util/ReflectionUtils.class");
        System.out.println(urlOfClass);
    }

    @Resource
    private UsersMapper usersMapper;

    @Test
    public void testAdd(){
        Users user=new Users();
        user.setPasswd("111111");
        user.setUsername("liyang");
        usersMapper.insertSelective(user);
    }

    @Test
    public void testFindUser(){
        Users  users=usersMapper.findByUsernameAndPasswd("111111","liyang");
        System.out.println(users);
    }
}
