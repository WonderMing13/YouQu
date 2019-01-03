package org.wonderming.springsecurity;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.wonderming.service.UserInfoService;

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
        return null;
    }
}
