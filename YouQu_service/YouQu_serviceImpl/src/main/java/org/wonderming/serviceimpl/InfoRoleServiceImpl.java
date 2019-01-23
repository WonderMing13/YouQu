package org.wonderming.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wonderming.mapper.UserInfoRoleMapper;
import org.wonderming.pojo.UserInfo;
import org.wonderming.pojo.UserInfoRole;
import org.wonderming.service.InfoRoleService;
import org.wonderming.service.UserRoleService;
import org.wonderming.utils.IdUtils;

import javax.annotation.Resource;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: 王德明
 * @Date: 2019/1/22
 * @Time: 16:46
 * @Project: youqu
 * @Package: org.wonderming.serviceimpl
 */
@Service
public class InfoRoleServiceImpl implements InfoRoleService {

    @Resource
    private UserInfoRoleMapper userInfoRoleMapper;

    @Autowired
    private UserRoleService userRoleService;

    @Override
    public void addUserInfoRole(UserInfo userInfo) {
        UserInfoRole userInfoRole = new UserInfoRole();
        userInfoRole.setId(IdUtils.creatKey());
        userInfoRole.setUserId(userInfo.getId());
        userInfoRole.setCreator("wangdm");
        userInfoRole.setCreateTime(new Date());
        userInfoRole.setRoleId(IdUtils.creatKey());
        userRoleService.addUserRole(userInfoRole);
        userInfoRoleMapper.insertSelective(userInfoRole);

    }
}
