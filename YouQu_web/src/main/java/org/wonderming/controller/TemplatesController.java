package org.wonderming.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.wonderming.aop.SystemControllerLog;
import org.wonderming.result.Result;
import org.wonderming.utils.IpUtils;

import javax.servlet.http.HttpServletRequest;

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
     * @param httpServletRequest
     * @return
     */
    @RequestMapping(value = "/getRealIp")
    @ResponseBody
    @SystemControllerLog(description = "获取IP")
    public String addIp(HttpServletRequest httpServletRequest) {
        return IpUtils.getClientIp(httpServletRequest);
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
