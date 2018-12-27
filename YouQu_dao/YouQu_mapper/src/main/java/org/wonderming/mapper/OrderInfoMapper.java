package org.wonderming.mapper;

import org.wonderming.pojo.OrderInfo;

/**
 * @author wonderming
 */
public interface OrderInfoMapper {
    /**
     * 根据主键删除
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Long id);

    /**
     * 添加orderInfo对象
     * @param record
     * @return
     */
    int insert(OrderInfo record);

    /**
     *  批量添加orderInfo对象
     * @param record
     * @return
     */
    int insertSelective(OrderInfo record);

    /**
     * 根据主键获取orderInfo对象
     * @param id
     * @return
     */
    OrderInfo selectByPrimaryKey(Long id);

    /**
     * 根据主键批量更新orderInfo
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(OrderInfo record);

    /**
     * 根据主键更新orderInfo
     * @param record
     * @return
     */
    int updateByPrimaryKey(OrderInfo record);
}