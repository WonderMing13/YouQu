package org.wonderming.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.wonderming.exception.ExceptionUtils;
import org.wonderming.pojo.SystemLog;
import org.wonderming.service.SystemLogService;
import org.wonderming.utils.IdUtils;
import org.wonderming.utils.IpUtils;


import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;


/**
 * Created with IntelliJ IDEA.
 *
 * @author: 王德明
 * @Date: 2018/12/26
 * @Time: 10:13
 * @Project: youqu
 * @Package: org.wonderming.aop
 *  使用Aspectj代替SpringAOP proxy-target-class="true"：使用cglib而不是jdk的来生成代理方法
 *  AOP有Aspectj和SpringAOP,代理方法有cglib(动态地对目标对象进行子类化来实现AOP代理,业务对象没有实现任何接口的时候默认会选择CGLIB)和jdk(只针对实现了接口的业务对象)
 */
@Aspect
@Component
public class SystemServiceAspect {

    private SystemLogService systemLogService;

    /**
     *  本地异常日志记录对象
     */
    private static final Logger SYSTEM_LOGGER = LoggerFactory.getLogger(SystemServiceAspect.class);
    /**
     *  初始化开始时间
     */
    private long startTime = 0L;
    /**
     *  异常信息类型
     */
    private static final short THROWABLE_TYPE = 4;

    /**
     *  service层AOP切点
     */
    @Pointcut("@annotation(org.wonderming.aop.SystemServiceLog)")
    public void serviceAspect() {
    }

    /**
     * 前置通知
     * @param joinPoint 切点
     */
    @Before("serviceAspect()")
    public void doBefore(JoinPoint joinPoint) {
        startTime = System.currentTimeMillis();
    }


    /**
     * 后置异常通知
     * @param joinPoint
     */
    @AfterThrowing(value = "serviceAspect()",throwing = "e")
    public void doAfterThrowing(JoinPoint joinPoint,Throwable e) {
        SystemLog systemLog = new SystemLog();
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (servletRequestAttributes != null) {
            systemLog.setRequestIp(IpUtils.getClientIp(servletRequestAttributes.getRequest()));
            systemLog.setRequestUrl(servletRequestAttributes.getRequest().getRequestURI());
        }
        systemLog.setId(IdUtils.creatKey());
        systemLog.setMessage(ExceptionUtils.getStackTrace(e));
        systemLog.setMethodName(joinPoint.getSignature().getName());
        systemLog.setMethodDescription(getServiceMethodDescription(joinPoint));
        systemLog.setStartTime(new Date(startTime));
        systemLog.setSpendTime(System.currentTimeMillis() - startTime);
        systemLog.setType(THROWABLE_TYPE);
        systemLogService.addSystemLogService(systemLog);
    }

    public static String getServiceMethodDescription(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        SystemServiceLog systemServiceLog = method.getAnnotation(SystemServiceLog.class);
        String description = systemServiceLog.description();
        return description;
    }

    public SystemLogService getSystemLogService() {
        return systemLogService;
    }

    public void setSystemLogService(SystemLogService systemLogService) {
        this.systemLogService = systemLogService;
    }
}
