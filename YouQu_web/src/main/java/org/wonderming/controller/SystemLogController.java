package org.wonderming.controller;


import org.springframework.web.bind.annotation.*;
import org.wonderming.aop.SystemControllerLog;
import org.wonderming.page.Page;
import org.wonderming.page.PageResult;
import org.wonderming.service.SystemLogService;
import org.wonderming.utils.JsonUtils;

import javax.annotation.Resource;


/**
 * Created with IntelliJ IDEA.
 *
 * @author: 王德明
 * @Date: 2019/1/15
 * @Time: 13:52
 * @Project: youqu
 * @Package: org.wonderming.controller
 */
@RestController
@RequestMapping("/systemLog")
public class SystemLogController {

    @Resource
    private SystemLogService systemLogService;

    /**
     * REST get请求操作获取资源
     * @param page
     * @return
     */
    @GetMapping("/getSystemLogList")
    public PageResult getSystemLogforList(Page page) {
        return systemLogService.getSystemLogforList(page);
    }



}
