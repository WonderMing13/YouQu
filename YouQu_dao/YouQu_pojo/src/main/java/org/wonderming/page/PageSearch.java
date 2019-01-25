package org.wonderming.page;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: 王德明
 * @Date: 2019/1/16
 * @Time: 13:44
 * @Project: youqu
 * @Package: org.wonderming.page
 */
public class PageSearch implements Serializable {
    /**
     * 类型
     */
    private Short type;
    /**
     * 方法描述
     */
    private String methodDescription;
    /**
     * 创建人
     */
    private String operator;
    /**
     * 开始时间
     */
    private Date startTime;
    /**
     * 结束时间
     */
    private Date endTime;

    public Short getType() {
        return type;
    }

    public void setType(Short type) {
        this.type = type;
    }

    public String getMethodDescription() {
        return methodDescription;
    }

    public void setMethodDescription(String methodDescription) {
        this.methodDescription = methodDescription;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public static void checkPageSearch(PageSearch pageSearch) {
        if (pageSearch != null && pageSearch.getEndTime() != null) {
            Calendar calendar = new GregorianCalendar();
            calendar.setTime(pageSearch.getEndTime());
            calendar.add(Calendar.DATE,1);
            pageSearch.setEndTime(calendar.getTime());
        }
    }
}
