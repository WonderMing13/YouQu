package org.wonderming.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * @author:wonderming
 * @date:2018-12-25 数据表order_info
 */
public class OrderInfo implements Serializable {
    /**
     * 列名:id类型:BIGINT(19)允许空:false默认值:null
     */
    private Long id;

    /**
     * 订单商品
     * 列名:merchant_id类型:BIGINT(19)允许空:true默认值:null
     */
    private Long merchantId;

    /**
     * 订单号
     * 列名:order_number类型:BIGINT(19)允许空:true默认值:null
     */
    private Long orderNumber;

    /**
     * 订单金额
     * 列名:order_amount类型:DECIMAL(10)允许空:true默认值:null
     */
    private Long orderAmount;

    /**
     * 是否交易成功 1:成功 0:失败
     * 列名:is_success类型:SMALLINT(5)允许空:true默认值:null
     */
    private Short isSuccess;

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
     * 订单商品
     *
     * @returnBIGINT
     */
    public Long getMerchantId() {
        return merchantId;
    }

    /**
     * 订单商品
     *
     * @paramBIGINT
     */
    public void setMerchantId(Long merchantId) {
        this.merchantId = merchantId;
    }

    /**
     * 订单号
     *
     * @returnBIGINT
     */
    public Long getOrderNumber() {
        return orderNumber;
    }

    /**
     * 订单号
     *
     * @paramBIGINT
     */
    public void setOrderNumber(Long orderNumber) {
        this.orderNumber = orderNumber;
    }

    /**
     * 订单金额
     *
     * @returnDECIMAL
     */
    public Long getOrderAmount() {
        return orderAmount;
    }

    /**
     * 订单金额
     *
     * @paramDECIMAL
     */
    public void setOrderAmount(Long orderAmount) {
        this.orderAmount = orderAmount;
    }

    /**
     * 是否交易成功 1:成功 0:失败
     *
     * @returnSMALLINT
     */
    public Short getIsSuccess() {
        return isSuccess;
    }

    /**
     * 是否交易成功 1:成功 0:失败
     *
     * @paramSMALLINT
     */
    public void setIsSuccess(Short isSuccess) {
        this.isSuccess = isSuccess;
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
        return "OrderInfo{" +
                "id=" + id +
                ", merchantId=" + merchantId +
                ", orderNumber=" + orderNumber +
                ", orderAmount=" + orderAmount +
                ", isSuccess=" + isSuccess +
                ", creator='" + creator + '\'' +
                ", createTime=" + createTime +
                ", modifier='" + modifier + '\'' +
                ", modifiyTime=" + modifiyTime +
                '}';
    }
}