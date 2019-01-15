package org.wonderming.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.wonderming.pojo.SystemLog;
import org.wonderming.service.SystemLogService;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: 王德明
 * @Date: 2019/1/15
 * @Time: 13:52
 * @Project: youqu
 * @Package: org.wonderming.controller
 */
@Controller
@RequestMapping("/systemLog")
public class SystemLogController {

    @Resource
    private SystemLogService systemLogService;

    @RequestMapping("/getSystemLogList")
    @ResponseBody
    public List<SystemLog> getSystemLogforList() {
        return systemLogService.getSystemLogforList();
    }

}
