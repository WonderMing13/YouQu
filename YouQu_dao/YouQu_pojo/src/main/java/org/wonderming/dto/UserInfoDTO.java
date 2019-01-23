package org.wonderming.dto;

import org.wonderming.pojo.UserInfo;
import org.wonderming.pojo.UserPrivilege;
import org.wonderming.pojo.UserRole;

import java.util.List;

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

    private List<UserPrivilege> privilegeList;

    public List<UserPrivilege> getPrivilegeList() {
        return privilegeList;
    }

    public void setPrivilegeList(List<UserPrivilege> privilegeList) {
        this.privilegeList = privilegeList;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

}
