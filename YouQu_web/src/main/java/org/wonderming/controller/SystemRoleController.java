package org.wonderming.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wonderming.pojo.UserRole;
import org.wonderming.service.UserRoleService;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: 王德明
 * @Date: 2019/2/18
 * @Time: 16:37
 * @Project: youqu
 * @Package: org.wonderming.controller
 */
@RestController
@RequestMapping(value = "/systemRole")
public class SystemRoleController {

    @Resource
    private UserRoleService userRoleService;

    @GetMapping(value = "/getAllUserRole")
    public List<UserRole> getAllUserRole(){
        return userRoleService.getAllUserRole();
    }
}
