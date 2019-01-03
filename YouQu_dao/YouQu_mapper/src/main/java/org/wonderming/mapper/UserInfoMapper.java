package org.wonderming.mapper;

import org.apache.ibatis.annotations.Param;
import org.wonderming.dto.UserInfoDTO;
import org.wonderming.pojo.UserInfo;

/**
 * @author wonderming
 */
public interface UserInfoMapper {
    /**
     * 根据主键来删除
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Long id);

    /**
     * 根据UserInfo添加
     * @param record
     * @return
     */
    int insert(UserInfo record);

    /**
     * 根据UserInfo批量添加
     * @param record
     * @return
     */
    int insertSelective(UserInfo record);

    /**
     * 根据主键查询到UserInfo
     * @param id
     * @return
     */
    UserInfo selectByPrimaryKey(Long id);

    /**
     * 根据UserInfo对象批量更新
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(UserInfo record);

    /**
     * 根据UserInfo对象更新
     * @param record
     * @return
     */
    int updateByPrimaryKey(UserInfo record);

    /**
     * 根据用户名来获取具体信息
     * @param username
     * @return
     */
    UserInfoDTO getUserInfoByUsername(@Param(value = "username")String username);
}