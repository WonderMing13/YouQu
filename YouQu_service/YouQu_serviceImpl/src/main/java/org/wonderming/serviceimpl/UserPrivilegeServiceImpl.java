package org.wonderming.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wonderming.mapper.UserPrivilegeMapper;
import org.wonderming.pojo.UserPrivilege;
import org.wonderming.pojo.UserRole;
import org.wonderming.service.UserPrivilegeService;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: 王德明
 * @Date: 2019/1/3
 * @Time: 9:59
 * @Project: youqu
 * @Package: org.wonderming.serviceimpl
 */
@Service
public class UserPrivilegeServiceImpl implements UserPrivilegeService {

    @Autowired
    private UserPrivilegeMapper userPrivilegeMapper;

    @Override
    public void addUserPrivilage(UserRole userRole) {
        UserPrivilege userPrivilage = new UserPrivilege();
        userPrivilage.setStateName("content.statistic");
        userPrivilage.setPrivilegeName("HOME_MANAGER");
        userPrivilage.setMenuName("首页管理");
        userPrivilegeMapper.insertSelective(userPrivilage);
    }

    @Override
    public List<UserPrivilege> getUserPrivilegeByRoleIdList(List<Long> roleIdList) {
        return userPrivilegeMapper.getUserPrivilegeByRoleIdList(roleIdList);
    }
}
