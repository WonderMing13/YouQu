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

    @SystemServiceLog(description = "获取异常")
    @Override
    public void addUserInfo(UserInfo userInfo) {
       userInfo.setAddress("xiamen");
       userInfo.setCreateTime(new Date());
       userInfo.setEmail("550207385@qq.com");
       userInfo.setId(IdUtils.creatKey());
       userInfo.setPhone("18750928494");
       userInfo.setRealName("王德明");
       userInfoMapper.insertSelective(userInfo);
       throw new RuntimeException("抛异常");
    }
}
