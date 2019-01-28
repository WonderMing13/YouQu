package org.wonderming.controller;

import org.springframework.web.bind.annotation.*;
import org.wonderming.dto.UserInfoDTO;
import org.wonderming.pojo.UserInfo;
import org.wonderming.service.UserInfoService;

import javax.annotation.Resource;
import java.util.List;

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

}
