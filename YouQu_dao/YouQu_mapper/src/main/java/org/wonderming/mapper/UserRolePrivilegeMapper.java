package org.wonderming.mapper;

import org.apache.ibatis.annotations.Param;
import org.wonderming.pojo.UserRolePrivilege;

import java.util.List;

/**
 * @author wonderming
 */
public interface UserRolePrivilegeMapper {
    /**
     * 根据主键删除
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Long id);

    /**
     * 插入
     * @param record
     * @return
     */
    int insert(UserRolePrivilege record);

    /**
     * 批量插入
     * @param record
     * @return
     */
    int insertSelective(UserRolePrivilege record);

    /**
     * 根据主键获取
     * @param id
     * @return
     */
    UserRolePrivilege selectByPrimaryKey(Long id);

    /**
     * 批量更新
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(UserRolePrivilege record);

    /**
     * 根据主键更新
     * @param record
     * @return
     */
    int updateByPrimaryKey(UserRolePrivilege record);


}