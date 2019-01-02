package org.wonderming.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wonderming.aop.SystemServiceLog;
import org.wonderming.mapper.UserInfoMapper;
import org.wonderming.pojo.UserInfo;
import org.wonderming.service.UserInfoService;
import org.wonderming.utils.IdUtils;

import java.util.Date;

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

    @Override
    public void addUserInfo() {
        UserInfo userInfo = new UserInfo();
        userInfo.setId(IdUtils.creatKey());
        userInfo.setPhone("18750928494");
        userInfo.setEmail("550207385@qq.com");
        userInfo.setCreator("wangdm");
        userInfo.setCreateTime(new Date());
        userInfo.setRealName("王总");
        userInfo.setAddress("xiamen");
        userInfo.setIsApply((short) 1);
        userInfo.setUserName("wangdm");
        //123456
        userInfo.setUserPassword("$2a$10$FuiXiEZ0R8BtJlGV/MdJxOi5YGsr9T.0.h0swIQxzjG/MO/fVxtc.");
        userInfo.setRoleId(IdUtils.creatKey());
        userInfoMapper.insertSelective(userInfo);
    }
}
