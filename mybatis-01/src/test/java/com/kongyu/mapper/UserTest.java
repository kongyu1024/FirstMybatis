package com.kongyu.mapper;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.kongyu.mybatisUtils.MybatisUtils;
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
}
