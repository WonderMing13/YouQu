package org.wonderming.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.wonderming.exception.ExceptionUtils;
import org.wonderming.pojo.SystemLog;
import org.wonderming.service.SystemLogService;
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
 * @Time: 10:13
 * @Project: youqu
 * @Package: org.wonderming.aop
 */
@Aspect
@Component
public class SystemServiceAspect {

    @Autowired
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
        HttpServletRequest request = (HttpServletRequest) RequestContextHolder.getRequestAttributes();
        systemLog.setId(IdUtils.creatKey());
        systemLog.setRequestIp(IpUtils.getClientIp(request));
        systemLog.setRequestUrl(request.getRequestURI());
        systemLog.setMessage(ExceptionUtils.getStackTrace(e));
        systemLog.setMethodName(joinPoint.getSignature().getName());
        systemLog.setMethodDescription(getServiceMethodDescription(joinPoint));
        systemLog.setStartTime(new Date(startTime));
        systemLog.setSpendTime(System.currentTimeMillis() - startTime);
        // systemLog.setOperator();
        // systemLog.setType();
    }

    public static String getServiceMethodDescription(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        SystemServiceLog systemServiceLog = method.getAnnotation(SystemServiceLog.class);
        String description = systemServiceLog.description();
        return description;
    }

}
