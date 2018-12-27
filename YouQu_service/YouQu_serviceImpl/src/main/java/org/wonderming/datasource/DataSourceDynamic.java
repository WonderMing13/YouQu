package org.wonderming.datasource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: 王德明
 * @Date: 2018/12/27
 * @Time: 9:18
 * @Project: youqu
 * @Package: org.wonderming.datasource
 */
public class DataSourceDynamic extends AbstractRoutingDataSource {

    /**spring
     * 获取数据源名称
     * @return
     */
    @Override
    protected Object determineCurrentLookupKey() {
        return DataSourceHandler.getDataSource();
    }

}
