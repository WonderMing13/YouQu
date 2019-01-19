package org.wonderming.page;

import java.io.Serializable;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: 王德明
 * @Date: 2019/1/16
 * @Time: 10:29
 * @Project: youqu
 * @Package: org.wonderming.page
 */
public class PageResult implements Serializable {
    /**
     *  总记录数
     */
    private Long total;
    /**
     *  总页数
     */
    private Integer pages;
    /**
     *  结果集
     */
    private List resultData;

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public List getResultData() {
        return resultData;
    }

    public void setResultData(List resultData) {
        this.resultData = resultData;
    }
}
