import com.fasterxml.jackson.databind.util.JSONPObject;
import org.junit.Test;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.wonderming.utils.IdUtils;
import org.wonderming.utils.IpUtils;
import springfox.documentation.spring.web.json.Json;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

        @Test
        public void ipTest() {
            List<Integer> list = new ArrayList<>();
            System.out.println(list.size());
        }

        @Test
        public void lambaTest() {
            List<String> list = Arrays.asList("aa","bb");
            Boolean thenString = list.stream().anyMatch(s -> s.equals("bb"));
            System.out.println(thenString);
        }

        @Test
        public void testPasswordList() {
            BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
            String password = bCryptPasswordEncoder.encode("123456");
            System.out.println(password);
            System.out.println(bCryptPasswordEncoder.matches("123456","$2a$10$wk3lDKRAV3toYm.hpBDVl.iBV2qfiheojmKdy2g24LWMwiQhsSiRK"));
        }

        @Test
        public void testSingleNum() {
            int a = 0;
            int b = 0;
            int c = a ^ b;
            System.out.println(c);
        }

        @Test
        public void testInteger() {
            int nums = 7;
            int times = nums / 2;
            System.out.println(times);
        }

        @Test
        public void testArrayString() {
            String[] array = new String[]{"zs","id"};
            // System.out.println(array.length);
            for (String anArray : array) {
                System.out.println(anArray);
            }
        }

}
