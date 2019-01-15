package org.wonderming.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wonderming.mapper.SystemLogMapper;
import org.wonderming.pojo.SystemLog;
import org.wonderming.service.SystemLogService;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: 王德明
 * @Date: 2018/12/26
 * @Time: 10:28
 * @Project: youqu
 * @Package: org.wonderming.serviceimpl
 */
@Service
public class SystemLogServiceImpl implements SystemLogService {

    @Autowired
    private SystemLogMapper systemLogMapper;


    @Override
    public void addSystemLogService(SystemLog systemLog) {
         systemLogMapper.insertSelective(systemLog);
    }

    @Override
    public List<SystemLog> getSystemLogforList() {
        return systemLogMapper.getSystemLogforList();
    }


}
