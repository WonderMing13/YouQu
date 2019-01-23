package org.wonderming.service;

import org.wonderming.pojo.UserInfo;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: 王德明
 * @Date: 2019/1/22
 * @Time: 16:43
 * @Project: youqu
 * @Package: org.wonderming.service
 */
public interface InfoRoleService {

    /**
     * 添加相关联的表
     * @param userInfo
     */
    void addUserInfoRole(UserInfo userInfo);
}
