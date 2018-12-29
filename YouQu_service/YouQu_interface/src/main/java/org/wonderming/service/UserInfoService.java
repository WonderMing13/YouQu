package org.wonderming.service;

import org.wonderming.pojo.UserInfo;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: 王德明
 * @Date: 2018/12/29
 * @Time: 15:28
 * @Project: youqu
 * @Package: org.wonderming.service
 */
public interface UserInfoService {

    /**
     * 添加用户信息
     * @param userInfo
     */
    void addUserInfo(UserInfo userInfo);
}
