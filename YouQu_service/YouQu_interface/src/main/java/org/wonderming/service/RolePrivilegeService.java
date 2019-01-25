package org.wonderming.service;

import org.wonderming.pojo.UserPrivilege;
import org.wonderming.pojo.UserRole;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: 王德明
 * @Date: 2019/1/22
 * @Time: 16:57
 * @Project: youqu
 * @Package: org.wonderming.service
 */
public interface RolePrivilegeService {

    /**
     * 添加关联表数据
     * @param userRole
     */
    void addUserRolePrivilege(UserRole userRole);



}
