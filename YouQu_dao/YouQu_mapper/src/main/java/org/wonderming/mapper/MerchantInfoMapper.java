package org.wonderming.mapper;

import org.wonderming.pojo.MerchantInfo;

/**
 * @author WonderMing
 */
public interface MerchantInfoMapper {
    /**
     * 根据主键来删除
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Long id);

    /**
     * 添加MerchantInfo对象
     * @param record
     * @return
     */
    int insert(MerchantInfo record);

    /**
     * 批量添加MerchantInfo
     * @param record
     * @return
     */
    int insertSelective(MerchantInfo record);

    /**
     * 根据主键来获取数据
     * @param id
     * @return
     */
    MerchantInfo selectByPrimaryKey(Long id);

    /**
     * 根据主键批量更新
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(MerchantInfo record);

    /**
     * 根据主键更新
     * @param record
     * @return
     */
    int updateByPrimaryKey(MerchantInfo record);
}