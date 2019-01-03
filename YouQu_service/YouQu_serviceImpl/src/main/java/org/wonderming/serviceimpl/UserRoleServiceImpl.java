package org.wonderming.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wonderming.mapper.UserInfoMapper;
import org.wonderming.mapper.UserRoleMapper;
import org.wonderming.pojo.UserInfo;
import org.wonderming.pojo.UserRole;
import org.wonderming.service.UserPrivilageService;
import org.wonderming.service.UserRoleService;
import org.wonderming.utils.IdUtils;

import javax.annotation.Resource;
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

    @Resource
    private UserPrivilageService userPrivilageService;

    @Override
    public void addUserRole(UserInfo userInfo) {
        UserRole userRole = new UserRole();
        userRole.setId(userInfo.getRoleId());
        userRole.setRole("ROLE_ADMIN");
        userRole.setRoleName("管理员");
        userRole.setCreator("wangdm");
        userRole.setCreateTime(new Date());
        userRole.setIsApply((short) 1);
        userRole.setPrivilageId(IdUtils.creatKey());
        userPrivilageService.addUserPrivilage(userRole);
        userRoleMapper.insertSelective(userRole);
    }
}
