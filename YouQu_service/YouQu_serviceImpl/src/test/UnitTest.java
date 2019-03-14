import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.wonderming.javapattern.FactoryMethod.BlackMan;
import org.wonderming.javapattern.FactoryMethod.Human;
import org.wonderming.javapattern.FactoryMethod.HumanFactory;
import org.wonderming.javapattern.Proxy.Agent;
import org.wonderming.javapattern.Singleton.Man;
import org.wonderming.javapattern.Strategy.Context;
import org.wonderming.javapattern.Strategy.GivenStrategy;
import org.wonderming.jedis.JedisClientTemplate;
import org.wonderming.service.OrderInfoService;



import java.util.Collections;
import java.util.UUID;
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
//    @Autowired
//    private JedisClientTemplate jedisClientTemplate;
    /**
     * redis setnx操作
     */
    private static final String SET_IF_NOT_EXIST = "NX";
    /**
     * redis expire操作
     */
    private static final String SET_WITH_EXPIRE_TIME = "PX";


    @Test
    public void testNum(){
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                System.out.println("当前线程是:" + Thread.currentThread().getName());
                orderInfoService.check("wonder");
            }).start();
        }
    }

    @Test
    public void testJavaPattern() {
        Context context = new Context(new GivenStrategy());
        context.operate();

        Agent agent = new Agent();
        agent.dribble();
        agent.dunk();

        Man man1 = Man.getInstance();
        Man man2 = Man.getInstance();

        Human blackMan = HumanFactory.createHuman(BlackMan.class);
        blackMan.cry();
        blackMan.laugh();
        blackMan.talk();

    }
}
