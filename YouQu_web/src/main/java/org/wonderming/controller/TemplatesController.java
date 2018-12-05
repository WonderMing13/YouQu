package org.wonderming.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: 王德明
 * @Date: 2018/12/4
 * @Time: 10:53
 * @Project: youqu
 * @Package: org.wonderming.controller
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

}