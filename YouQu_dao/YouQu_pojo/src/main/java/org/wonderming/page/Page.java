package org.wonderming.page;

import com.github.pagehelper.PageHelper;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: 王德明
 * @Date: 2019/1/15
 * @Time: 17:08
 * @Project: youqu
 * @Package: org.wonderming.page
 */
public class Page implements Serializable {
    /**
     * 当前页数
     */
    private Integer pageNum;
    /**
     * 当前数量
     */
    private Integer pageCount;
    /**
     * 排序
     */
    private String[] orderBy;
    /**
     * 查找条件
     */
    private PageSearch pageSearch;

    /**
     * 查找条件String
     */
    private String pageSearchString;

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    public String[] getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String[] orderBy) {
        this.orderBy = orderBy;
    }

    public PageSearch getPageSearch() {
        return pageSearch;
    }

    public void setPageSearch(PageSearch pageSearch) {
        this.pageSearch = pageSearch;
    }

    public String getPageSearchString() {
        return pageSearchString;
    }

    public void setPageSearchString(String pageSearchString) {
        this.pageSearchString = pageSearchString;
    }

    public static void checkOrderBy(Page page) {
        if (page.getOrderBy() == null) {
            page.setOrderBy(new String[]{"id DESC"});
            for (String orderby:page.getOrderBy()){
                PageHelper.orderBy(orderby);
            }
        }else {
            for (String orderby:page.getOrderBy()){
                PageHelper.orderBy(orderby);
            }
        }
    }
}


