package org.wonderming.jedis;

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

    @Override
    public String set(String key, String value, String nxxx, String expx, long time) {
        Jedis jedis = jedisPool.getResource();
        String result = jedis.set(key, value, nxxx, expx, time);
        jedis.close();
        return result;
    }

    @Override
    public Object eval(String script, List<String> keys, List<String> args) {
        Jedis jedis = jedisPool.getResource();
        Object result = jedis.eval(script,keys,args);
        jedis.close();
        return result;
    }
}
