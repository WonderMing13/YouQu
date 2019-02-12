package org.wonderming.jedis;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: 王德明
 * @Date: 2019/2/12
 * @Time: 11:01
 * @Project: youqu
 * @Package: org.wonderming.jedis
 */
public interface JedisClient {

    /**
     *
     * @param key 前缀key值
     * @param value 客户端唯一标识
     * @param nxxx set if not exist
     * @param expx 过期标识
     * @param time 过期时间
     * @return
     */
    String set(String key, String value, String nxxx, String expx, long time);

    /**
     *
     * @param script 脚本
     * @param keys
     * @param args
     * @return
     */
    Object eval(String script, List<String> keys, List<String> args);
}
