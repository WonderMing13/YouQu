package org.wonderming.serviceimpl;

import org.springframework.stereotype.Service;
import org.wonderming.mapper.UserRolePrivilegeMapper;
import org.wonderming.pojo.UserPrivilege;
import org.wonderming.pojo.UserRole;
import org.wonderming.pojo.UserRolePrivilege;
import org.wonderming.service.RolePrivilegeService;
import org.wonderming.utils.IdUtils;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: 王德明
 * @Date: 2019/1/22
 * @Time: 16:58
 * @Project: youqu
 * @Package: org.wonderming.serviceimpl
 */
@Service
public class RolePrivilegeServiceImpl implements RolePrivilegeService {

    @Resource
    private UserRolePrivilegeMapper userRolePrivilegeMapper;


    @Override
    public void addUserRolePrivilege(UserRole userRole) {
        UserRolePrivilege userRolePrivilege = new UserRolePrivilege();
        userRolePrivilege.setId(IdUtils.creatKey());
        userRolePrivilege.setRoleId(userRole.getId());
        userRolePrivilege.setPrivilegeId(IdUtils.creatKey());
        userRolePrivilege.setCreator("wangdm");
        userRolePrivilege.setCreateTime(new Date());
        userRolePrivilegeMapper.insertSelective(userRolePrivilege);
    }

}
