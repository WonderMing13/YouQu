package org.wonderming.serviceimpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;
import org.wonderming.mapper.SystemLogMapper;
import org.wonderming.page.Page;
import org.wonderming.page.PageResult;
import org.wonderming.page.PageSearch;
import org.wonderming.pojo.SystemLog;
import org.wonderming.service.SystemLogService;
import org.wonderming.utils.JsonUtils;

import java.util.Calendar;
import java.util.GregorianCalendar;
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

    /**
     * pagehelper不支持for update sql语句行锁，这种情况下需要对后端进行手动分页就是对sql语句的limit page，count.
     * @param page 页数 页码
     * @return
     */
    // @Cacheable(value = "system_log",key ="#page.pageNum")
    @Override
    public PageResult getSystemLogforList(Page page) {
        PageSearch pageSearch = JsonUtils.jsonToPojo(page.getPageSearchString(),PageSearch.class);
        Page.checkOrderBy(page);
        PageSearch.checkPageSearch(pageSearch);
        PageHelper.startPage(page.getPageNum(),page.getPageCount());
        List<SystemLog> logList =  systemLogMapper.getSystemLogforList(pageSearch);
        PageInfo<SystemLog> pageInfo = new PageInfo<>(logList);
        PageResult pageResult = new PageResult();
        pageResult.setPages(pageInfo.getPages());
        pageResult.setTotal(pageInfo.getTotal());
        pageResult.setResultData(pageInfo.getList());
        return pageResult;
    }

}
