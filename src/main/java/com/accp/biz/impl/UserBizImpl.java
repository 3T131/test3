package com.accp.biz.impl;

import com.accp.biz.UserBiz;
import com.accp.dao.UserMapper;
import com.accp.entity.User;
import com.accp.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

public class UserBizImpl implements UserBiz  {

    UserMapper userMapper=null;
    public User login(String userName,String userPwd) {
        SqlSession sqlSession = MyBatisUtil.openSession();
        userMapper=sqlSession.getMapper(UserMapper.class);
        return userMapper.queryUser(new User(userName, userPwd));
    }
}
