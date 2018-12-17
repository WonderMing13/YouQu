import org.junit.Test;
import org.wonderming.utils.IdUtils;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: 王德明
 * @Date: 2018/11/29
 * @Time: 13:47
 * @Project: youqu
 * @Package: PACKAGE_NAME
 */
public class UnitTest {

        @Test
        public void poJoTest() {
            String[] a = {"1","2"};
            System.out.println(Arrays.deepToString(a));
        }

        @Test
        public void dateTest() {
            Thread thread = new Thread();
            for (int i = 0; i < 100; i++) {
                System.out.println(IdUtils.creatKey());
                try {
                        thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                }
            }
            thread.start();
        }
}
