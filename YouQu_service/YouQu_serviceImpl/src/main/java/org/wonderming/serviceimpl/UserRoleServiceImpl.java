package org.wonderming.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wonderming.mapper.UserRoleMapper;
import org.wonderming.pojo.UserInfoRole;
import org.wonderming.pojo.UserRole;
import org.wonderming.service.RolePrivilegeService;
import org.wonderming.service.UserRoleService;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: 王德明
 * @Date: 2019/1/3
 * @Time: 9:30
 * @Project: youqu
 * @Package: org.wonderming.serviceimpl
 */
@Service
public class UserRoleServiceImpl implements UserRoleService {

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Autowired
    private RolePrivilegeService rolePrivilegeService;

    @Override
    public void addUserRole(UserInfoRole userInfoRole) {
        UserRole userRole = new UserRole();
        userRole.setId(userInfoRole.getRoleId());
        userRole.setRole("ADMIN");
        userRole.setRoleName("管理员");
        userRole.setCreator("wangdm");
        userRole.setCreateTime(new Date());
        userRole.setIsApply((short) 1);
        rolePrivilegeService.addUserRolePrivilege(userRole);
        userRoleMapper.insertSelective(userRole);
    }

}
