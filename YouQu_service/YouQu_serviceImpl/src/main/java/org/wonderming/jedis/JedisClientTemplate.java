package org.wonderming.jedis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: 王德明
 * @Date: 2019/2/12
 * @Time: 11:07
 * @Project: youqu
 * @Package: org.wonderming.jedis
 */
public class JedisClientTemplate implements JedisClient {

    @Autowired
    private JedisPool jedisPool;

    private static final Logger JEDIS_LOGGER = LoggerFactory.getLogger(JedisClientTemplate.class);

    @Override
    public String set(String key, String value, String nxxx, String expx, long time) {
        String result = null;
        Jedis jedis = null;
        try {
             jedis = jedisPool.getResource();
             result = jedis.set(key, value, nxxx, expx, time);
        } catch (Exception e) {
            JEDIS_LOGGER.error("jedis set error",e);
            returnResource(jedis);
        } finally {
            returnResource(jedis);
        }
        return result;
    }

    @Override
    public Object eval(String script, List<String> keys, List<String> args) {
        Object result = null;
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            result = jedis.eval(script, keys, args);
        } catch (Exception e) {
            JEDIS_LOGGER.error("jedis delete error",e);
            returnResource(jedis);
        } finally {
            returnResource(jedis);
        }
        return result;
    }

    /**
     * 回收jedis对象
     * @param jedis
     */
    private synchronized void returnResource(Jedis jedis) {
        if (jedis != null) {
            jedis.close();
        }
    }


}
