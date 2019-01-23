package org.wonderming.mapper;

import org.wonderming.pojo.UserInfoRole;

/**
 * @author wonderming
 */
public interface UserInfoRoleMapper {
    /**
     *  根据主键删除
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Long id);

    /**
     *  插入
     * @param record
     * @return
     */
    int insert(UserInfoRole record);

    /**
     * 批量插入
     * @param record
     * @return
     */
    int insertSelective(UserInfoRole record);

    /**
     * 根据主键获取数据
     * @param id
     * @return
     */
    UserInfoRole selectByPrimaryKey(Long id);

    /**
     * 根据主键批量更新
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(UserInfoRole record);

    /**
     * 根据主键更新数据
     * @param record
     * @return
     */
    int updateByPrimaryKey(UserInfoRole record);
}