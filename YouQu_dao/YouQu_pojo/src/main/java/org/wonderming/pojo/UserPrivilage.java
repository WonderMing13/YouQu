package org.wonderming.pojo;

import java.io.Serializable;

/**
 * @author:wonderming
 * @date2018-12-25 数据表user_privilage
 */
public class UserPrivilage implements Serializable {
    /**
     * 列名:id类型:BIGINT(19)允许空:false默认值:null
     */
    private Long id;

    /**
     * 权限
     * 列名:privilege_name类型:VARCHAR(45)允许空:true默认值:null
     */
    private String privilegeName;

    /**
     * 菜单显示名称
     * 列名:menu_name类型:VARCHAR(8)允许空:true默认值:null
     */
    private String menuName;

    /**
     * 所属父级id
     * 列名:parent_id类型:BIGINT(19)允许空:true默认值:null
     */
    private Long parentId;

    /**
     * 模块名称
     * 列名:state_name类型:VARCHAR(50)允许空:true默认值:null
     */
    private String stateName;


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
     * 权限
     *
     * @returnVARCHAR
     */
    public String getPrivilegeName() {
        return privilegeName;
    }

    /**
     * 权限
     *
     * @paramVARCHAR
     */
    public void setPrivilegeName(String privilegeName) {
        this.privilegeName = privilegeName == null ? null : privilegeName.trim();
    }

    /**
     * 菜单显示名称
     *
     * @returnVARCHAR
     */
    public String getMenuName() {
        return menuName;
    }

    /**
     * 菜单显示名称
     *
     * @paramVARCHAR
     */
    public void setMenuName(String menuName) {
        this.menuName = menuName == null ? null : menuName.trim();
    }

    /**
     * 所属父级id
     *
     * @returnBIGINT
     */
    public Long getParentId() {
        return parentId;
    }

    /**
     * 所属父级id
     *
     * @paramBIGINT
     */
    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    /**
     * 模块名称
     *
     * @returnVARCHAR
     */
    public String getStateName() {
        return stateName;
    }

    /**
     * 模块名称
     *
     * @paramVARCHAR
     */
    public void setStateName(String stateName) {
        this.stateName = stateName == null ? null : stateName.trim();
    }

    @Override
    public String toString() {
        return "UserPrivilage{" +
                "id=" + id +
                ", privilegeName='" + privilegeName + '\'' +
                ", menuName='" + menuName + '\'' +
                ", parentId=" + parentId +
                ", stateName='" + stateName + '\'' +
                '}';
    }
}