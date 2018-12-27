package org.wonderming.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * @author: wonderming
 * @date: 2018-12-25
 * 数据表merchant_info
 */
public class MerchantInfo implements Serializable {
    /**
     * 列名:id类型:BIGINT(19)允许空:false默认值:null
     */
    private Long id;

    /**
     * 商品名称
     * 列名:merchant_name类型:VARCHAR(50)允许空:true默认值:null
     */
    private String merchantName;

    /**
     * 商品价格
     * 列名:price类型:DECIMAL(10)允许空:true默认值:null
     */
    private Long price;

    /**
     * 商品产地
     * 列名:merchant_production类型:VARCHAR(15)允许空:true默认值:null
     */
    private String merchantProduction;

    /**
     * 商品描述
     * 列名:description类型:VARCHAR(50)允许空:true默认值:null
     */
    private String description;

    /**
     * 是否在售 0:在售 1;禁售
     * 列名:is_sold类型:SMALLINT(5)允许空:true默认值:null
     */
    private Short isSold;

    /**
     * 创建人
     * 列名:creator类型:VARCHAR(15)允许空:true默认值:null
     */
    private String creator;

    /**
     * 创建时间
     * 列名:creator_time类型:TIMESTAMP(19)允许空:true默认值:null
     */
    private Date creatorTime;

    /**
     * 确认人
     * 列名:modifier类型:VARCHAR(15)允许空:true默认值:null
     */
    private String modifier;

    /**
     * 确认时间
     * 列名:modifiy_time类型:TIMESTAMP(19)允许空:true默认值:null
     */
    private Date modifiyTime;


    /**
     * @return BIGINT
     */
    public Long getId() {
        return id;
    }

    /**
     * @param:BIGINT
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 商品名称
     *
     * @return VARCHAR
     */
    public String getMerchantName() {
        return merchantName;
    }

    /**
     * 商品名称
     *
     * @param:VARCHAR
     */
    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName == null ? null : merchantName.trim();
    }

    /**
     * 商品价格
     *
     * @return DECIMAL
     */
    public Long getPrice() {
        return price;
    }

    /**
     * 商品价格
     *
     * @param:DECIMAL
     */
    public void setPrice(Long price) {
        this.price = price;
    }

    /**
     * 商品产地
     *
     * @return VARCHAR
     */
    public String getMerchantProduction() {
        return merchantProduction;
    }

    /**
     * 商品产地
     *
     * @paramVARCHAR
     */
    public void setMerchantProduction(String merchantProduction) {
        this.merchantProduction = merchantProduction == null ? null : merchantProduction.trim();
    }

    /**
     * 商品描述
     *
     * @return VARCHAR
     */
    public String getDescription() {
        return description;
    }

    /**
     * 商品描述
     *
     * @param:VARCHAR
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * 是否在售 0:在售 1;禁售
     *
     * @return SMALLINT
     */
    public Short getIsSold() {
        return isSold;
    }

    /**
     * 是否在售 0:在售 1;禁售
     *
     * @param:SMALLINT
     */
    public void setIsSold(Short isSold) {
        this.isSold = isSold;
    }

    /**
     * 创建人
     *
     * @return VARCHAR
     */
    public String getCreator() {
        return creator;
    }

    /**
     * 创建人
     *
     * @param:VARCHAR
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
        return "MerchantInfo{" +
                "id=" + id +
                ", merchantName='" + merchantName + '\'' +
                ", price=" + price +
                ", merchantProduction='" + merchantProduction + '\'' +
                ", description='" + description + '\'' +
                ", isSold=" + isSold +
                ", creator='" + creator + '\'' +
                ", creatorTime=" + creatorTime +
                ", modifier='" + modifier + '\'' +
                ", modifiyTime=" + modifiyTime +
                '}';
    }
}