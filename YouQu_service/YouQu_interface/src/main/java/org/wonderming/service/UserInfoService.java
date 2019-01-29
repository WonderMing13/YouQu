package org.wonderming.service;

import org.wonderming.dto.UserInfoDTO;
import org.wonderming.pojo.UserInfo;

import java.util.List;


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

    /**
     * 获取所有用户信息
     * @return
     */
    List<UserInfoDTO> getAllSystemUser();

    /**
     * 更新用户状态
     * @param userInfo
     * @return
     */
    Integer updateUserStatus(UserInfo userInfo);


    /**
     * 修改用户密码
     * @param userInfo
     * @return
     */
    Integer updateUserPassword(UserInfo userInfo);

}
