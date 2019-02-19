package org.wonderming.mapper;

import org.wonderming.pojo.UserRole;

import java.util.List;

/**
 * @author wonderming
 */
public interface UserRoleMapper {
    /**
     * 根据主键删除
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Long id);

    /**
     * 根据UserRole对象插入
     * @param record
     * @return
     */
    int insert(UserRole record);

    /**
     * 根据UserRole对象批量插入
     * @param record
     * @return
     */
    int insertSelective(UserRole record);

    /**
     * 根据主键获取UserRole对象
     * @param id
     * @return
     */
    UserRole selectByPrimaryKey(Long id);

    /**
     * 根据UserRole批量更新
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(UserRole record);

    /**
     * 根据UserRole更新
     * @param record
     * @return
     */
    int updateByPrimaryKey(UserRole record);

    /**
     * 获取全部角色
     * @return
     */
    List<UserRole> getAllUserRole();


}