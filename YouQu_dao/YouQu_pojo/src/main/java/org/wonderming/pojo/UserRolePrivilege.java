package org.wonderming.pojo;

import java.util.Date;

/**
 * @author:wonderming
 * @date2019-01-22 数据表user_role_privilege
 */
public class UserRolePrivilege {
    /**
     * 列名:id类型:BIGINT(19)允许空:false默认值:null
     */
    private Long id;

    /**
     * user_role表的外键
     * 列名:role_id类型:BIGINT(19)允许空:true默认值:null
     */
    private Long roleId;

    /**
     * user_privilege表的外键
     * 列名:privilege_id类型:BIGINT(19)允许空:true默认值:null
     */
    private Long privilegeId;

    /**
     * 创建人
     * 列名:creator类型:VARCHAR(10)允许空:true默认值:null
     */
    private String creator;

    /**
     * 创建时间
     * 列名:create_time类型:TIMESTAMP(19)允许空:true默认值:null
     */
    private Date createTime;

    /**
     * 修改人
     * 列名:modifier类型:VARCHAR(10)允许空:true默认值:null
     */
    private String modifier;

    /**
     * 确认时间
     * 列名:modify_time类型:TIMESTAMP(19)允许空:true默认值:null
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
     * user_role表的外键
     *
     * @returnBIGINT
     */
    public Long getRoleId() {
        return roleId;
    }

    /**
     * user_role表的外键
     *
     * @paramBIGINT
     */
    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    /**
     * user_privilege表的外键
     *
     * @returnBIGINT
     */
    public Long getPrivilegeId() {
        return privilegeId;
    }

    /**
     * user_privilege表的外键
     *
     * @paramBIGINT
     */
    public void setPrivilegeId(Long privilegeId) {
        this.privilegeId = privilegeId;
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
     * 修改人
     *
     * @returnVARCHAR
     */
    public String getModifier() {
        return modifier;
    }

    /**
     * 修改人
     *
     * @paramVARCHAR
     */
    public void setModifier(String modifier) {
        this.modifier = modifier == null ? null : modifier.trim();
    }

    /**
     * 确认时间
     *
     * @returnTIMESTAMP
     */
    public Date getModifyTime() {
        return modifyTime;
    }

    /**
     * 确认时间
     *
     * @paramTIMESTAMP
     */
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    @Override
    public String toString() {
        return "UserRolePrivilege{" +
                "id=" + id +
                ", roleId=" + roleId +
                ", privilegeId=" + privilegeId +
                ", creator='" + creator + '\'' +
                ", createTime=" + createTime +
                ", modifier='" + modifier + '\'' +
                ", modifyTime=" + modifyTime +
                '}';
    }
}