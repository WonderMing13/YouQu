package org.wonderming.service;


import org.wonderming.pojo.UserPrivilege;
import org.wonderming.pojo.UserRole;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: 王德明
 * @Date: 2019/1/3
 * @Time: 9:57
 * @Project: youqu
 * @Package: org.wonderming.service
 */
public interface UserPrivilegeService {

    /**
     *  添加用户权限
     * @param userRole
     */
    void addUserPrivilage(UserRole userRole);

    /**
     * 跟user_role和user_privilage的关联id来查询
     * @param roleId
     * @return
     */
    List<UserPrivilege> getUserPrivilegeByRoleId(Long roleId);
}
