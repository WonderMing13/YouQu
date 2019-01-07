package org.wonderming.mapper;

import org.wonderming.pojo.SystemLog;

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
}