package org.wonderming.springsecurity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.wonderming.dto.UserInfoDTO;
import org.wonderming.exception.BaseException;
import org.wonderming.pojo.UserRole;
import org.wonderming.service.UserInfoService;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: 王德明
 * @Date: 2019/1/2
 * @Time: 11:57
 * @Project: youqu
 * @Package: org.wonderming.springsecurity
 */
public class MyUserDetailsServiceImpl implements UserDetailsService {

    private UserInfoService userInfoService;

    public UserInfoService getUserInfoService() {
        return userInfoService;
    }

    public void setUserInfoService(UserInfoService userInfoService) {
        this.userInfoService = userInfoService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfoDTO userInfoDTO = userInfoService.getUserInfoByUsername(username);
        if (userInfoDTO == null) {
            throw new UsernameNotFoundException("无法根据用户名查找到用户" + username);
        } else if(userInfoDTO.getUserPrivilegeList().size() == 0) {
            throw new BaseException("该用户无权限！");
        }
        return toUserDeatils(userInfoDTO);
    }

    /**
     * 获取用户名的角色和权限
     * @param userInfoDTO
     * @return
     */
    private UserDetails toUserDeatils(UserInfoDTO userInfoDTO) {
        List<GrantedAuthority> authorityList = new ArrayList<>();
        List<String> stringList = new ArrayList<>();
        for (UserRole userRole : userInfoDTO.getUserRoleList()) {
            stringList.add(userRole.getRole());
        }
        userInfoDTO.getUserPrivilegeList().stream().distinct().forEach(userPrivilage -> authorityList.add(new SimpleGrantedAuthority(userPrivilage.getPrivilegeName())));
        return User.withUsername(userInfoDTO.getUserName()).password(userInfoDTO.getUserPassword()).roles(String.valueOf(stringList)).authorities(authorityList).build();
    }
}
