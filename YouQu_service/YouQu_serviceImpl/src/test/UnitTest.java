import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.wonderming.service.OrderInfoService;


import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: 王德明
 * @Date: 2019/1/31
 * @Time: 15:21
 * @Project: youqu
 * @Package: PACKAGE_NAME
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:springcontext/applicationContext-*.xml"})
public class UnitTest {

    @Autowired
    private OrderInfoService orderInfoService;

    @Test
    public void testNum() throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> orderInfoService.check("CHEN")).start();
        }
    }
}
