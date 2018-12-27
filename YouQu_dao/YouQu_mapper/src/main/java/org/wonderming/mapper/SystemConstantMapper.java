package org.wonderming.mapper;

import org.wonderming.pojo.SystemConstant;

/**
 * @author wonderming
 */
public interface SystemConstantMapper {
    /**
     * 根据主键删除
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Long id);

    /**
     * 插入systemconstant对象
     * @param record
     * @return
     */
    int insert(SystemConstant record);

    /**
     * 批量插入systemconstant对象
     * @param record
     * @return
     */
    int insertSelective(SystemConstant record);

    /**
     * 根据主键获取systemconstant对象
     * @param id
     * @return
     */
    SystemConstant selectByPrimaryKey(Long id);

    /**
     * 根据systemconstant批量更新
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(SystemConstant record);

    /**
     * 根据systemconstant对象更新
     * @param record
     * @return
     */
    int updateByPrimaryKey(SystemConstant record);
}