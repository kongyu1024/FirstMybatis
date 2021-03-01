package com.kongyu.mapper;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.kongyu.utils.MybatisUtils;
import com.kongyu.pojo.User;

/**
 * @Author kongyu
 * @create 2021/3/1 16:15
 */
public class UserTest {
    @Test
    public void getUserList(){
        SqlSession sqlSession = MybatisUtils.getSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = mapper.getUserList();
        for (User user : userList) {
            System.out.println(user);
        }
        sqlSession.close();
    }

    @Test
    public void getUserById(){
        SqlSession sqlSession = MybatisUtils.getSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User userById = mapper.getUserById(1);
        System.out.println(userById);
        sqlSession.close();
    }

    @Test
    public void addUser(){
        User user1 = new User();
        user1.setId(4);
        user1.setName("赵老八");
        user1.setPwd("123456Aa");
        SqlSession session = MybatisUtils.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        mapper.addUser(user1);
        session.commit();
        session.close();
        System.out.println("添加完毕");
    }
    @Test
    public void updateUser(){
        User user1 = new User();
        user1.setId(4);
        user1.setName("赵老九");
        user1.setPwd("123456Aa");
        SqlSession session = MybatisUtils.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        int i = mapper.updateUser(user1);
        if(i>0){
            System.out.println("添加完毕");
        }
        session.commit();
        session.close();
    }



}
