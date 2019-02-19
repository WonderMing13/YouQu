package org.wonderming.serviceimpl;

import org.springframework.stereotype.Service;
import org.wonderming.redislock.CacheLock;
import org.wonderming.service.OrderInfoService;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: 王德明
 * @Date: 2019/1/31
 * @Time: 15:13
 * @Project: youqu
 * @Package: org.wonderming.serviceimpl
 */
@Service
public class OrderInfoServiceImpl implements OrderInfoService {

    private static int i = 0;

    @CacheLock(lockedPrefix = "wonder")
    @Override
    public void check(String key) {
        i++;
        System.out.println(key + "=========" +i);
    }
}
