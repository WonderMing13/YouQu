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

    private List<UserRole> userRoleList;

    private List<UserPrivilege> userPrivilegeList;

    public List<UserPrivilege> getUserPrivilegeList() {
        return userPrivilegeList;
    }

    public void setUserPrivilegeList(List<UserPrivilege> userPrivilegeList) {
        this.userPrivilegeList = userPrivilegeList;
    }

    public List<UserRole> getUserRoleList() {
        return userRoleList;
    }

    public void setUserRoleList(List<UserRole> userRoleList) {
        this.userRoleList = userRoleList;
    }
}
