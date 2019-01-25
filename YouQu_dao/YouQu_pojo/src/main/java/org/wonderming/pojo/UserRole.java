package org.wonderming.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * @author:wonderming
 * @date:2018-12-25 数据表user_role
 */
public class UserRole implements Serializable {
    /**
     * 列名:id类型:BIGINT(19)允许空:false默认值:null
     */
    private Long id;

    /**
     * 角色
     * 列名:role类型:VARCHAR(45)允许空:true默认值:null
     */
    private String role;

    /**
     * 角色名称
     * 列名:role_name类型:VARCHAR(5)允许空:true默认值:null
     */
    private String roleName;

    /**
     * 是否启用 0:禁用 1:启用
     * 列名:is_apply类型:SMALLINT(5)允许空:true默认值:null
     */
    private Short isApply;

    /**
     * 创建人
     * 列名:creator类型:VARCHAR(15)允许空:true默认值:null
     */
    private String creator;

    /**
     * 创建时间
     * 列名:create_time类型:TIMESTAMP(19)允许空:true默认值:null
     */
    private Date createTime;

    /**
     * 确认人
     * 列名:modifier类型:VARCHAR(15)允许空:true默认值:null
     */
    private String modifier;

    /**
     * 确认时间
     * 列名:modifiy_time类型:TIMESTAMP(19)允许空:true默认值:null
     */
    private Date modifyTime;


    /**
     * @returnBIGINT
     */
    public Long getId() {
        return id;
    }

    /**
     * @paramBIGINT
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 角色
     *
     * @returnVARCHAR
     */
    public String getRole() {
        return role;
    }

    /**
     * 角色
     *
     * @paramVARCHAR
     */
    public void setRole(String role) {
        this.role = role == null ? null : role.trim();
    }

    /**
     * 角色名称
     *
     * @returnVARCHAR
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * 角色名称
     *
     * @paramVARCHAR
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

    /**
     * 是否启用 0:禁用 1:启用
     *
     * @returnSMALLINT
     */
    public Short getIsApply() {
        return isApply;
    }

    /**
     * 是否启用 0:禁用 1:启用
     *
     * @paramSMALLINT
     */
    public void setIsApply(Short isApply) {
        this.isApply = isApply;
    }

    /**
     * 创建人
     *
     * @returnVARCHAR
     */
    public String getCreator() {
        return creator;
    }

    /**
     * 创建人
     *
     * @paramVARCHAR
     */
    public void setCreator(String creator) {
        this.creator = creator == null ? null : creator.trim();
    }

    /**
     * 创建时间
     *
     * @returnTIMESTAMP
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 创建时间
     *
     * @paramTIMESTAMP
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 确认人
     *
     * @returnVARCHAR
     */
    public String getModifier() {
        return modifier;
    }

    /**
     * 确认人
     *
     * @param:VARCHAR
     */
    public void setModifier(String modifier) {
        this.modifier = modifier == null ? null : modifier.trim();
    }

    /**
     * 确认时间
     *
     * @return TIMESTAMP
     */
    public Date getModifyTime() {
        return modifyTime;
    }

    /**
     * 确认时间
     *
     * @param:TIMESTAMP
     */
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

}