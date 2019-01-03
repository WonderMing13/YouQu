package org.wonderming.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wonderming.mapper.UserPrivilageMapper;
import org.wonderming.pojo.UserPrivilage;
import org.wonderming.pojo.UserRole;
import org.wonderming.service.UserPrivilageService;

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
public class UserPrivilageServiceImpl implements UserPrivilageService {

    @Autowired
    private UserPrivilageMapper userPrivilageMapper;

    @Override
    public void addUserPrivilage(UserRole userRole) {
        UserPrivilage userPrivilage = new UserPrivilage();
        userPrivilage.setId(userRole.getPrivilageId());
        userPrivilage.setStateName("dashboards.dashboard_2");
        userPrivilage.setPrivilegeName("HOME_STATISTICS");
        userPrivilage.setMenuName("首页统计");
        userPrivilageMapper.insertSelective(userPrivilage);
    }
}
