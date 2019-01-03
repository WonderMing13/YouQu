package org.wonderming.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.wonderming.aop.SystemControllerLog;
import org.wonderming.dto.UserInfoDTO;
import org.wonderming.pojo.UserInfo;
import org.wonderming.service.UserInfoService;


import javax.annotation.Resource;


/**
 * Created with IntelliJ IDEA.
 *
 * @author: 王德明
 * @Date: 2018/12/4
 * @Time: 10:53
 * @Project: youqu
 * @Package: org.wonderming.controller
 * swagger2:{@link: [项目访问地址]/swagger-ui.html }
 */
@Controller
public class TemplatesController {

    @Resource
    private UserInfoService userInfoService;

    /**
     * 首页
     * @return
     */
    @RequestMapping(value = "/")
    public String viewIndex() {
        return "index";
    }

    /**
     * 页面调度
     * @param page
     * @return
     */
    @RequestMapping(value = "/views/{page}")
    public String viewDispatch(@PathVariable String page) {
        return "views/" + page;
    }

    /**
     * 二级页面调度
     * @param fileName
     * @param page
     * @return
     */
    @RequestMapping(value = "/views/{fileName}/{page}")
    public String viewSecondDispatch(@PathVariable String fileName,@PathVariable String page) {
        return "views/" + fileName + "/" + page;
    }

    /**
     * 获取客户机ip
     * @param
     * @return
     */
    @RequestMapping(value = "/getRealIp")
    @ResponseBody
    @SystemControllerLog(description = "添加用户")
    public void addIp() {
        UserInfoDTO userInfoDTO = userInfoService.getUserInfoByUsername("wangdm");
        System.out.println(userInfoDTO.toString());
    }

    /**
     * 登录页面
     * @return
     */
    @RequestMapping(value = "/user/login")
    public String viewsLoginPage() {
        return "views/login";
    }

    /**
     * 错误页面
     * @return
     */
    @RequestMapping(value = "/error")
    public String viewsLoginErrorPage() {
        return "views/error";
    }

}
