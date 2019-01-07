package org.wonderming.service;

import org.wonderming.dto.UserInfoDTO;



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
     * @param
     */
    void addUserInfo();

    /**
     * 根据用户名获取具体信息
     * @param username
     * @return
     */
    UserInfoDTO getUserInfoByUsername(String username);

}