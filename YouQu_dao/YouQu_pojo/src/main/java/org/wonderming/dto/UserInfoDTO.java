package org.wonderming.dto;

import org.wonderming.pojo.UserInfo;
import org.wonderming.pojo.UserRole;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: 王德明
 * @Date: 2019/1/3
 * @Time: 14:03
 * @Project: youqu
 * @Package: org.wonderming.dto
 */
public class UserInfoDTO extends UserInfo {

    private UserRole userRole;

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    @Override
    public String toString() {
        return "UserInfoDTO{" +
                "userRole=" + userRole +
                '}';
    }
}
