package org.wonderming.service;

import org.wonderming.pojo.SystemLog;

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
}
