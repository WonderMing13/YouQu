package org.wonderming.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.wonderming.dto.UserInfoDTO;
import org.wonderming.exception.BaseException;
import org.wonderming.mapper.UserInfoMapper;
import org.wonderming.pojo.UserInfo;
import org.wonderming.pojo.UserPrivilege;
import org.wonderming.pojo.UserRole;
import org.wonderming.service.*;
import org.wonderming.utils.IdUtils;

import java.util.*;


/**
 * Created with IntelliJ IDEA.
 *
 * @author: 王德明
 * @Date: 2018/12/29
 * @Time: 15:29
 * @Project: youqu
 * @Package: org.wonderming.serviceimpl
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Autowired
    private InfoRoleService infoRoleService;

    @Autowired
    private UserPrivilegeService userPrivilegeService;

    @Override
    public void addUserInfo() {
        UserInfo userInfo = new UserInfo();
        userInfo.setId(IdUtils.creatKey());
        userInfo.setPhone("18750928494");
        userInfo.setEmail("550207385@qq.com");
        userInfo.setCreator("wangdm");
        userInfo.setCreateTime(new Date());
        userInfo.setRealName("王德明");
        userInfo.setAddress("xiamen");
        userInfo.setIsApply((short) 1);
        userInfo.setUserName("wangdm");
        //123456
        userInfo.setUserPassword("$2a$10$FuiXiEZ0R8BtJlGV/MdJxOi5YGsr9T.0.h0swIQxzjG/MO/fVxtc.");
        infoRoleService.addUserInfoRole(userInfo);
        userInfoMapper.insertSelective(userInfo);
    }

    @Override
    public UserInfoDTO getUserInfoByUsername(String username) {
        List<Long> roleIdList = new ArrayList<>();
        if (StringUtils.isEmpty(username)) {
            return null;
        }
        UserInfoDTO userInfoDTO = userInfoMapper.getUserInfoByUsername(username);
        List<UserRole> userRoles = userInfoDTO.getUserRoleList();
        if (userRoles.size() == 0) {
            throw new BaseException("该用户无角色信息！");
        }
        for (UserRole userRole : userRoles) {
            roleIdList.add(userRole.getId());
        }
        List<UserPrivilege> userPrivilegeList = userPrivilegeService.getUserPrivilegeByRoleIdList(roleIdList);
        userInfoDTO.setUserPrivilegeList(userPrivilegeList);
        return userInfoDTO;
    }

    @Override
    public List<UserInfoDTO> getAllSystemUser() {
        return userInfoMapper.getAllSystemUser();
    }

    @Override
    public Integer updateUserStatus(UserInfo userInfo) {
        return userInfoMapper.updateByPrimaryKeySelective(userInfo);
    }


}
