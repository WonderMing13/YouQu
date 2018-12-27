package org.wonderming.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * @author:wonderming
 * @date2018-12-26 数据表system_log
 */
public class SystemLog implements Serializable {
    /**
     * 列名:id类型:BIGINT(19)允许空:false默认值:null
     */
    private Long id;

    /**
     * 创建人
     * 列名:operator类型:VARCHAR(15)允许空:true默认值:null
     */
    private String operator;

    /**
     * 创建时间
     * 列名:start_time类型:TIMESTAMP(19)允许空:true默认值:null
     */
    private Date startTime;

    /**
     * 确认时间
     * 列名:spend_time类型:BIGINT(19)允许空:true默认值:null
     */
    private Long spendTime;

    /**
     * 类型
     * 列名:type类型:SMALLINT(5)允许空:true默认值:null
     */
    private Short type;

    /**
     * 请求IP
     * 列名:request_ip类型:VARCHAR(15)允许空:true默认值:null
     */
    private String requestIp;

    /**
     * 请求URL
     * <p>
     * 列名:request_url类型:VARCHAR(25)允许空:true默认值:null
     */
    private String requestUrl;

    /**
     * 方法名称
     * 列名:method_name类型:VARCHAR(10)允许空:true默认值:null
     */
    private String methodName;

    /**
     * 方法描述
     * 列名:method_description类型:VARCHAR(4)允许空:true默认值:null
     */
    private String methodDescription;

    /**
     * 返回结果
     * 列名:message类型:LONGVARCHAR(65535)允许空:true默认值:null
     */
    private String message;

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
     * 创建人
     *
     * @returnVARCHAR
     */
    public String getOperator() {
        return operator;
    }

    /**
     * 创建人
     *
     * @paramVARCHAR
     */
    public void setOperator(String operator) {
        this.operator = operator == null ? null : operator.trim();
    }

    /**
     * 创建时间
     *
     * @returnTIMESTAMP
     */
    public Date getStartTime() {
        return startTime;
    }

    /**
     * 创建时间
     *
     * @paramTIMESTAMP
     */
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    /**
     * 确认时间
     *
     * @returnBIGINT
     */
    public Long getSpendTime() {
        return spendTime;
    }

    /**
     * 确认时间
     *
     * @paramBIGINT
     */
    public void setSpendTime(Long spendTime) {
        this.spendTime = spendTime;
    }

    /**
     * 类型
     *
     * @returnSMALLINT
     */
    public Short getType() {
        return type;
    }

    /**
     * 类型
     *
     * @paramSMALLINT
     */
    public void setType(Short type) {
        this.type = type;
    }

    /**
     * 请求IP
     *
     * @returnVARCHAR
     */
    public String getRequestIp() {
        return requestIp;
    }

    /**
     * 请求IP
     *
     * @paramVARCHAR
     */
    public void setRequestIp(String requestIp) {
        this.requestIp = requestIp == null ? null : requestIp.trim();
    }

    /**
     * 请求URL
     *
     * @returnVARCHAR
     */
    public String getRequestUrl() {
        return requestUrl;
    }

    /**
     * 请求URL
     *
     * @paramVARCHAR
     */
    public void setRequestUrl(String requestUrl) {
        this.requestUrl = requestUrl == null ? null : requestUrl.trim();
    }

    /**
     * 方法名称
     *
     * @returnVARCHAR
     */
    public String getMethodName() {
        return methodName;
    }

    /**
     * 方法名称
     *
     * @paramVARCHAR
     */
    public void setMethodName(String methodName) {
        this.methodName = methodName == null ? null : methodName.trim();
    }

    /**
     * 方法描述
     *
     * @returnVARCHAR
     */
    public String getMethodDescription() {
        return methodDescription;
    }

    /**
     * 方法描述
     *
     * @paramVARCHAR
     */
    public void setMethodDescription(String methodDescription) {
        this.methodDescription = methodDescription == null ? null : methodDescription.trim();
    }

    /**
     * 返回结果
     *
     * @returnLONGVARCHAR
     */
    public String getMessage() {
        return message;
    }

    /**
     * 返回结果
     *
     * @paramLONGVARCHAR
     */
    public void setMessage(String message) {
        this.message = message == null ? null : message.trim();
    }

    @Override
    public String toString() {
        return "SystemLog{" +
                "id=" + id +
                ", operator='" + operator + '\'' +
                ", startTime=" + startTime +
                ", spendTime=" + spendTime +
                ", type=" + type +
                ", requestIp='" + requestIp + '\'' +
                ", requestUrl='" + requestUrl + '\'' +
                ", methodName='" + methodName + '\'' +
                ", methodDescription='" + methodDescription + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}