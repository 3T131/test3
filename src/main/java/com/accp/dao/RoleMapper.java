package com.accp.dao;

import com.accp.entity.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleMapper {
    int addRole(Role role);
    int removeRole(Integer id);
    int modifyRole(Role role);
    List<Role> listByName(String roleName);
    Role listById(@Param("id") Integer id);
}
