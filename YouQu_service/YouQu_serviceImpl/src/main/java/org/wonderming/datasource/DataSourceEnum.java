package org.wonderming.datasource;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: 王德明
 * @Date: 2018/12/27
 * @Time: 11:17
 * @Project: youqu
 * @Package: org.wonderming.datasource
 */
public enum DataSourceEnum {
    /**
     * 读数据源
     */
    READ("read"),
    /**
     * 写数据源
     */
    WRITE("write");

    private String key;

    DataSourceEnum(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    @Override
    public String toString() {
        return "DataSourceEnum{" +
                "key='" + key + '\'' +
                '}';
    }
}
