package org.wonderming.service;

import org.wonderming.pojo.UserRole;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: 王德明
 * @Date: 2019/1/3
 * @Time: 9:57
 * @Project: youqu
 * @Package: org.wonderming.service
 */
public interface UserPrivilageService {

    /**
     *  添加用户权限
     * @param userRole
     */
    void addUserPrivilage(UserRole userRole);
}
