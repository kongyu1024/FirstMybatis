package com.kongyu.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import com.kongyu.pojo.UserNoPwd;
import com.kongyu.utils.MybatisUtils;
import com.kongyu.pojo.User;


/**
 * @Author kongyu
 * @create 2021/3/1 16:15
 */
public class UserTest {
    static Logger logger = Logger.getLogger(UserTest.class);
//    @Test
//    public void getUserList(){
//        logger.info("info:进入getUserList方法");
//        logger.debug("debug：进入selectUser方法");
//        logger.error("error: 进入selectUser方法");
//        SqlSession sqlSession = MybatisUtils.getSession();
//        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
////        List<User> userList = mapper.getUserList();
//        for (User user : userList) {
//            System.out.println(user);
//        }
//        sqlSession.close();
//    }

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

    @Test
    public void deleteUser(){
        SqlSession sqlSession = MybatisUtils.getSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int i = mapper.deleteUser(4);
        if(i>0){
            System.out.println("删除编号为4的数据成功");
        }else{
            System.out.println("删除编号为4的数据失败");
        }
        sqlSession.commit();
        sqlSession.close();
    }



    @Test
    public void selectAllUserNopwd(){
        SqlSession sqlSession = MybatisUtils.getSession();
        UserNopwdMapper mapper = sqlSession.getMapper(UserNopwdMapper.class);
        List<UserNoPwd> userNoPwds = mapper.selectAllUser();
        for (UserNoPwd user : userNoPwds) {
            System.out.println(user);
        }
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void selectAllUsers(){
        SqlSession session = MybatisUtils.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        int currentPage = 1;
        int pageSize = 3;
        Map<String,Integer> map = new HashMap<>();
        map.put("startIndex",(currentPage-1)*pageSize);
        map.put("pageSize",pageSize);
        List<User> users = mapper.selectAllUser(map);
        for (User user : users) {
            System.out.println(user);
        }

//        session.commit();
        session.close();

    }



}
