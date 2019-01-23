package org.wonderming.mapper;

import org.apache.ibatis.annotations.Param;
import org.wonderming.pojo.UserPrivilege;

import java.util.List;

/**
 * @author wonderming
 */
public interface UserPrivilegeMapper {
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
    int insert(UserPrivilege record);

    /**
     * 根据UserPrivilage批量插入
     * @param record
     * @return
     */
    int insertSelective(UserPrivilege record);

    /**
     * 根据主键获取UserPrivilage
     * @param id
     * @return
     */
    UserPrivilege selectByPrimaryKey(Long id);

    /**
     * 根据UserPrivilage对象批量更新
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(UserPrivilege record);

    /**
     * 根据UserPrivilage对象更新
     * @param record
     * @return
     */
    int updateByPrimaryKey(UserPrivilege record);


    /**
     * 根据关联id查询权限
     * @param roleId
     * @return
     */
    List<UserPrivilege> getUserPrivilegeByRoleId(@Param(value = "roleId") Long roleId);
}