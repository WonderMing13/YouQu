package org.wonderming.controller;


import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.wonderming.dto.UserInfoDTO;
import org.wonderming.service.UserInfoService;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


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

    /**
     * 验证session共享
     * @param httpServletRequest
     * @return
     */
    @RequestMapping(value = "/getSession")
    public String getSession(HttpServletRequest httpServletRequest) {
        HttpSession httpSession = httpServletRequest.getSession();
        httpSession.setAttribute("userName", SecurityContextHolder.getContext().getAuthentication().getName());
        return "views/mutl";
    }

}
