package org.wonderming.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.wonderming.pojo.SystemLog;
import org.wonderming.utils.IdUtils;
import org.wonderming.utils.IpUtils;
import org.wonderming.utils.JsonUtils;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: 王德明
 * @Date: 2018/12/26
 * @Time: 10:14
 * @Project: youqu
 * @Package: org.wonderming.aop
 */
@Aspect
@Component
public class SystemControllerAspect {

    /**
     *  本地异常日志记录对象
     */
    private static final Logger SYSTEM_LOGGER = LoggerFactory.getLogger(SystemControllerAspect.class);
    /**
     *  初始化开始时间
     */
    private long startTime = 0L;

    /**
     *  controller层AOP切点
     */
    @Pointcut("@annotation(org.wonderming.aop.SystemControllerLog)")
    public void controllerAspect() {
    }

    /**
     * 前置通知
     * @param joinPoint
     */
    @Before("controllerAspect()")
    public void doBefore(JoinPoint joinPoint) {
        startTime = System.currentTimeMillis();
    }

    /**
     * 后置通知
     * @param joinPoint
     */
    @After("controllerAspect()")
    public void doAfter(JoinPoint joinPoint){
        SystemLog systemLog = new SystemLog();
        HttpServletRequest request = (HttpServletRequest) RequestContextHolder.getRequestAttributes();
        String ip = IpUtils.getClientIp(request);
        String url = request.getRequestURI();
        systemLog.setId(IdUtils.creatKey());
        systemLog.setStartTime(new Date(startTime));
        systemLog.setSpendTime(System.currentTimeMillis() - startTime);
        systemLog.setRequestUrl(url);
        systemLog.setRequestIp(ip);
        systemLog.setMethodDescription(getControllerMethodDescription(joinPoint));
        systemLog.setMethodName(joinPoint.getSignature().getName());
        systemLog.setMessage(joinPoint.getArgs().length > 0 ? JsonUtils.objectToJson(joinPoint.getArgs()) : null);
        // systemLog.setOperator("");
        // systemLog.setType();
    }

    /**
     * 获取对方法的描述
     * Controller层
     * @param joinPoint
     * @return
     */
    public static String getControllerMethodDescription(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        SystemControllerLog controllerLog = method.getAnnotation(SystemControllerLog.class);
        String description = controllerLog.description();
        return description;
    }
}
