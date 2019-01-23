package org.wonderming.mapper;

import org.apache.ibatis.annotations.Param;
import org.wonderming.page.Page;
import org.wonderming.page.PageSearch;
import org.wonderming.pojo.SystemLog;

import java.util.List;

/**
 * @author wondemring
 */
public interface SystemLogMapper {
    /**
     * 根据主键来删除
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Long id);

    /**
     * 根据对象添加
     * @param record
     * @return
     */
    int insert(SystemLog record);

    /**
     * 根据对象批量添加
     * @param record
     * @return
     */
    int insertSelective(SystemLog record);

    /**
     * 根据主键返回对象
     * @param id
     * @return
     */
    SystemLog selectByPrimaryKey(Long id);

    /**
     * 根据对象批量更新
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(SystemLog record);


    /**
     * 根据对象更新
     * @param record
     * @return
     */
    int updateByPrimaryKey(SystemLog record);


    /**
     * 获取系统日志的数据
     * @param pageSearch 查找条件
     * @return List<SystemLog>
     */
    List<SystemLog> getSystemLogforList(PageSearch pageSearch);
}