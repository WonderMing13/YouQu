package org.wonderming.mapper;

import org.wonderming.pojo.UserPrivilage;

/**
 * @author wonderming
 */
public interface UserPrivilageMapper {
    /**
     * 根据主键删除
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Long id);

    /**
     * 根据UserPrivilage对象插入
     * @param record
     * @return
     */
    int insert(UserPrivilage record);

    /**
     * 根据UserPrivilage批量插入
     * @param record
     * @return
     */
    int insertSelective(UserPrivilage record);

    /**
     * 根据主键获取UserPrivilage
     * @param id
     * @return
     */
    UserPrivilage selectByPrimaryKey(Long id);

    /**
     * 根据UserPrivilage对象批量更新
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(UserPrivilage record);

    /**
     * 根据UserPrivilage对象更新
     * @param record
     * @return
     */
    int updateByPrimaryKey(UserPrivilage record);
}