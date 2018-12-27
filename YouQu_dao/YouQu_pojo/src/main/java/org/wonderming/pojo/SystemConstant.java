package org.wonderming.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * @author:wonderming
 * @date:2018-12-25 数据表system_constant
 */
public class SystemConstant implements Serializable {
    /**
     * 列名:id类型:BIGINT(19)允许空:false默认值:null
     */
    private Long id;

    /**
     * 常量名称
     * 列名:constant_name类型:VARCHAR(15)允许空:true默认值:null
     */
    private String constantName;

    /**
     * 常量值
     * 列名:constant_value类型:SMALLINT(5)允许空:true默认值:null
     */
    private Short constantValue;

    /**
     * 常量组别
     * 列名:group_code类型:VARCHAR(20)允许空:true默认值:null
     */
    private String groupCode;

    /**
     * 常量所需排序
     * 列名:sort_value类型:INTEGER(10)允许空:true默认值:null
     */
    private Integer sortValue;

    /**
     * 创建人
     * <p>
     * 列名:creator类型:VARCHAR(15)允许空:true默认值:null
     */
    private String creator;

    /**
     * 创建时间
     * <p>
     * 列名:creator_time类型:TIMESTAMP(19)允许空:true默认值:null
     */
    private Date creatorTime;

    /**
     * 确认人
     * <p>
     * 列名:modifier类型:VARCHAR(15)允许空:true默认值:null
     */
    private String modifier;

    /**
     * 确认时间
     * 列名:modifiy_time类型:TIMESTAMP(19)允许空:true默认值:null
     */
    private Date modifiyTime;


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
     * 常量名称
     *
     * @returnVARCHAR
     */
    public String getConstantName() {
        return constantName;
    }

    /**
     * 常量名称
     *
     * @paramVARCHAR
     */
    public void setConstantName(String constantName) {
        this.constantName = constantName == null ? null : constantName.trim();
    }

    /**
     * 常量值
     *
     * @returnSMALLINT
     */
    public Short getConstantValue() {
        return constantValue;
    }

    /**
     * 常量值
     *
     * @paramSMALLINT
     */
    public void setConstantValue(Short constantValue) {
        this.constantValue = constantValue;
    }

    /**
     * 常量组别
     *
     * @returnVARCHAR
     */
    public String getGroupCode() {
        return groupCode;
    }

    /**
     * 常量组别
     *
     * @paramVARCHAR
     */
    public void setGroupCode(String groupCode) {
        this.groupCode = groupCode == null ? null : groupCode.trim();
    }

    /**
     * 常量所需排序
     *
     * @returnINTEGER
     */
    public Integer getSortValue() {
        return sortValue;
    }

    /**
     * 常量所需排序
     *
     * @paramINTEGER
     */
    public void setSortValue(Integer sortValue) {
        this.sortValue = sortValue;
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
    public Date getCreatorTime() {
        return creatorTime;
    }

    /**
     * 创建时间
     *
     * @paramTIMESTAMP
     */
    public void setCreatorTime(Date creatorTime) {
        this.creatorTime = creatorTime;
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

    @Override
    public String toString() {
        return "SystemConstant{" +
                "id=" + id +
                ", constantName='" + constantName + '\'' +
                ", constantValue=" + constantValue +
                ", groupCode='" + groupCode + '\'' +
                ", sortValue=" + sortValue +
                ", creator='" + creator + '\'' +
                ", creatorTime=" + creatorTime +
                ", modifier='" + modifier + '\'' +
                ", modifiyTime=" + modifiyTime +
                '}';
    }
}