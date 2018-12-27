package org.wonderming.datasource;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: 王德明
 * @Date: 2018/12/27
 * @Time: 9:49
 * @Project: youqu
 * @Package: org.wonderming.datasource
 */
public class DataSourceHandler {
    /**
     *  数据源名称线程池
     */
    public static final ThreadLocal<String> holder = new ThreadLocal<String>();

    /**
     * 项目启动时把读,写数据源加到线程池中
     * @param datasource
     */
    public static void addDataSource(String datasource) {
        holder.set(datasource);
    }

    /**
     * 获取数据源字符串
     * @return
     */
    public static String getDataSource() {
        return holder.get();
    }
}
