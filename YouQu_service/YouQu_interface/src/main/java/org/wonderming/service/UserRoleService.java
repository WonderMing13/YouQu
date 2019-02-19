package org.wonderming.service;

import org.wonderming.pojo.UserInfoRole;
import org.wonderming.pojo.UserRole;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: 王德明
 * @Date: 2019/1/3
 * @Time: 9:29
 * @Project: youqu
 * @Package: org.wonderming.service
 */
public interface UserRoleService {

    /**
     * 添加角色
     * @param
     */
    void addUserRole(UserInfoRole userInfoRole);


    /**
     * 获取全部角色信息
     * @return
     */
    List<UserRole> getAllUserRole();

}
