package org.wonderming.service;

import org.wonderming.page.Page;
import org.wonderming.page.PageResult;
import org.wonderming.pojo.SystemLog;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: 王德明
 * @Date: 2018/12/26
 * @Time: 10:27
 * @Project: youqu
 * @Package: org.wonderming.service
 */
public interface SystemLogService {

    /**
     * 添加系统日志
     * @param systemLog
     */
    void addSystemLogService(SystemLog systemLog);

    /**
     * 获取系统日志的数据
     * @param page 页数 页码
     * @return 根据封装的页进行分页
     */
    PageResult getSystemLogforList(Page page);

}
