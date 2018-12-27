package org.wonderming.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * @author:wonderming
 * @date2018-12-25 数据表user_info
 */
public class UserInfo implements Serializable {
    /**
     * 列名:id类型:BIGINT(19)允许空:false默认值:null
     */
    private Long id;

    /**
     * 用户登录账号
     * 列名:user_name类型:VARCHAR(15)允许空:true默认值:null
     */
    private String userName;

    /**
     * 密码
     * 列名:user_password类型:VARCHAR(100)允许空:true默认值:null
     */
    private String userPassword;

    /**
     * 用户的角色
     * 列名:role_id类型:BIGINT(19)允许空:true默认值:null
     */
    private Long roleId;

    /**
     * 用户真实姓名
     * 列名:real_name类型:VARCHAR(5)允许空:true默认值:null
     */
    private String realName;

    /**
     * 手机号
     * 列名:phone类型:CHAR(11)允许空:true默认值:null
     */
    private String phone;

    /**
     * 邮箱
     * 列名:email类型:VARCHAR(20)允许空:true默认值:null
     */
    private String email;

    /**
     * 收货地址
     * 列名:address类型:VARCHAR(45)允许空:true默认值:null
     */
    private String address;

    /**
     * 是否启用 0:禁用 1:启用
     * 列名:is_apply类型:SMALLINT(5)允许空:true默认值:1
     */
    private Short isApply;

    /**
     * 确认人
     * 列名:modifier类型:VARCHAR(10)允许空:true默认值:null
     */
    private String modifier;

    /**
     * 确认时间
     * 列名:modifiy_time类型:TIMESTAMP(19)允许空:true默认值:null
     */
    private Date modifiyTime;

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
     * 用户登录账号
     *
     * @returnVARCHAR
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 用户登录账号
     *
     * @paramVARCHAR
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    /**
     * 密码
     *
     * @returnVARCHAR
     */
    public String getUserPassword() {
        return userPassword;
    }

    /**
     * 密码
     *
     * @paramVARCHAR
     */
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword == null ? null : userPassword.trim();
    }

    /**
     * 用户的角色
     *
     * @returnBIGINT
     */
    public Long getRoleId() {
        return roleId;
    }

    /**
     * 用户的角色
     *
     * @paramBIGINT
     */
    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    /**
     * 用户真实姓名
     *
     * @returnVARCHAR
     */
    public String getRealName() {
        return realName;
    }

    /**
     * 用户真实姓名
     *
     * @paramVARCHAR
     */
    public void setRealName(String realName) {
        this.realName = realName == null ? null : realName.trim();
    }

    /**
     * 手机号
     *
     * @returnCHAR
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 手机号
     *
     * @paramCHAR
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**
     * 邮箱
     *
     * @returnVARCHAR
     */
    public String getEmail() {
        return email;
    }

    /**
     * 邮箱
     *
     * @paramVARCHAR
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * 收货地址
     *
     * @returnVARCHAR
     */
    public String getAddress() {
        return address;
    }

    /**
     * 收货地址
     *
     * @paramVARCHAR
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
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
    public Date getModifiyTime() {
        return modifiyTime;
    }

    /**
     * 确认时间
     *
     * @paramTIMESTAMP
     */
    public void setModifiyTime(Date modifiyTime) {
        this.modifiyTime = modifiyTime;
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

    @Override
    public String toString() {
        return "UserInfo{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", roleId=" + roleId +
                ", realName='" + realName + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", isApply=" + isApply +
                ", modifier='" + modifier + '\'' +
                ", modifiyTime=" + modifiyTime +
                ", creator='" + creator + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}