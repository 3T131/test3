package com.accp.dao;

import com.accp.entity.Pager;
import com.accp.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {

    List<User> listAll();
    int removeByRoleId(@Param("roleId") Integer roleId);

    /**
     * 用户登陆
     * @param user
     * @return
     */
    User queryUser(User user);

    Pager<User> listByPager();
}
