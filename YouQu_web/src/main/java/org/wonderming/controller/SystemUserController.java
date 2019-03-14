package org.wonderming.controller;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.session.FindByIndexNameSessionRepository;
import org.springframework.session.Session;
import org.springframework.session.data.redis.RedisOperationsSessionRepository;
import org.springframework.web.bind.annotation.*;
import org.wonderming.dto.UserInfoDTO;
import org.wonderming.pojo.UserInfo;
import org.wonderming.service.UserInfoService;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;


/**
 * Created with IntelliJ IDEA.
 *
 * @author: 王德明
 * @Date: 2019/1/24
 * @Time: 10:41
 * @Project: youqu
 * @Package: org.wonderming.controller
 */
@RestController
@RequestMapping("/systemUser")
public class SystemUserController {

    @Resource
    private UserInfoService userInfoService;

    @Resource
    private BCryptPasswordEncoder passwordEncoder;

    @Resource
    private FindByIndexNameSessionRepository<? extends Session> sessionRepository;

    @Resource
    private RedisOperationsSessionRepository redisOperationsSessionRepository;

    /**
     * 获取全部用户信息
     * @return
     */
    @GetMapping(value = "/getAllSystemUser")
    public List<UserInfoDTO> getAllSystemUser() {
        return userInfoService.getAllSystemUser();
    }


    /**
     * 启用与禁用
     * @param userInfo
     * @return
     */
    @PutMapping(value = "/updateUserStatus")
    public Integer updateUserStatus(@RequestBody UserInfo userInfo) {
        return userInfoService.updateUserStatus(userInfo);
    }


    /**
     * 重置用户密码
     * @param userInfo
     * @return
     */
    @PutMapping(value = "/updateUserPassword")
    public Integer updateUserPassword(@RequestBody UserInfo userInfo) {
        if (userInfo.getUserPassword() != null) {
            userInfo.setUserPassword(passwordEncoder.encode(userInfo.getUserPassword()));
        }
        Integer flag = userInfoService.updateUserPassword(userInfo);
        if (flag == 1) {
            Map<String, ? extends Session> nameAndIndexValue = sessionRepository.findByIndexNameAndIndexValue(FindByIndexNameSessionRepository.PRINCIPAL_NAME_INDEX_NAME,userInfo.getUserName());
            nameAndIndexValue.forEach((s, o) -> redisOperationsSessionRepository.delete(s));
        }
        return flag;
    }

}
