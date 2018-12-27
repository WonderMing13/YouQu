package org.wonderming.datasource;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;
import org.springframework.util.PatternMatchUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: 王德明
 * @Date: 2018/12/27
 * @Time: 9:54
 * @Project: youqu
 * @Package: org.wonderming.datasource
 */
@Aspect
@Component
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class DataSourceAspect {

    private Map<String, String> methodType = new HashMap<>();

    public Map<String, String> getMethodType() {
        return methodType;
    }

    public void setMethodType(Map<String, String> methodType) {
        this.methodType = methodType;
    }

    /**
     * 配置切入点
     */
    @Pointcut("execution(* org.wonderming.serviceimpl..*.*(..))")
    public void dataSourceAspect() {
    }

    /**
     *  前置通知
     * @param joinPoint
     */
    @Before("dataSourceAspect()")
    public void doBefore(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        for (String key : methodType.keySet()) {
            String[] values = methodType.get(key).split(",");
            if (key.equals(DataSourceEnum.READ.getKey())) {
                if (PatternMatchUtils.simpleMatch(values, methodName)) {
                    DataSourceHandler.addDataSource(DataSourceEnum.READ.getKey());
                }
            } else if (key.equals(DataSourceEnum.WRITE.getKey())) {
                if (PatternMatchUtils.simpleMatch(values, methodName)) {
                    DataSourceHandler.addDataSource(DataSourceEnum.WRITE.getKey());
                }
            }
        }
    }


}
