package org.wonderming.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wonderming.dto.UserInfoDTO;
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

    @GetMapping(value = "/getAllSystemUser")
    public List<UserInfoDTO> getAllSystemUser() {
        return userInfoService.getAllSystemUser();
    }

}
