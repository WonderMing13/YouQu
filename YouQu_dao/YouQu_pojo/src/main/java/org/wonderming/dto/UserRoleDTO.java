package org.wonderming.dto;

import org.wonderming.pojo.UserPrivilage;
import org.wonderming.pojo.UserRole;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: 王德明
 * @Date: 2019/1/3
 * @Time: 14:05
 * @Project: youqu
 * @Package: org.wonderming.dto
 */
public class UserRoleDTO extends UserRole {
    private List<UserPrivilage> userPrivilageList;

    public List<UserPrivilage> getUserPrivilageList() {
        return userPrivilageList;
    }

    public void setUserPrivilageList(List<UserPrivilage> userPrivilageList) {
        this.userPrivilageList = userPrivilageList;
    }

    @Override
    public String toString() {
        return "UserRoleDTO{" +
                "userPrivilageList=" + userPrivilageList +
                '}';
    }
}
