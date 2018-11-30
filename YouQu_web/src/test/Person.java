import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: 王德明
 * @Date: 2018/11/29
 * @Time: 13:42
 * @Project: youqu
 * @Package: PACKAGE_NAME
 */
public class Person {

    private String userName;

    private List<Person> friends;

    public Person() {

    }

    public Person(String userName, List<Person> friends) {
        this.userName = userName;
        this.friends = friends;
    }
}
