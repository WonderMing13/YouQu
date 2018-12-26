package org.wonderming.aop;

import java.lang.annotation.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: 王德明
 * @Date: 2018/12/26
 * @Time: 10:00
 * @Project: youqu
 * @Package: org.wonderming.aop
 */

@Target({ElementType.PARAMETER,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SystemServiceLog {
    String description() default "";
}
