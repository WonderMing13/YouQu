package org.wonderming.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.wonderming.pojo.SystemLog;
import org.wonderming.service.SystemLogService;
import org.wonderming.utils.IdUtils;
import org.wonderming.utils.IpUtils;
import org.wonderming.utils.JsonUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.List;

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
    @Resource
    private SystemLogService systemLogService;

    /**
     *  本地异常日志记录对象
     */
    private static final Logger SYSTEM_LOGGER = LoggerFactory.getLogger(SystemControllerAspect.class);
    /**
     *  初始化开始时间
     */
    private long startTime = 0L;
    /**
     *  获取数据类型
     */
    private static final short GET_NUM = 0;
    /**
     *  插入数据类型
     */
    private static final short ADD_NUM = 1;
    /**
     *  更新数据类型
     */
    private static final short UPDATE_NUM = 2;
    /**
     *  删除数据类型
     */
    private static final short DELETE_NUM = 3;
    /**
     *  获取数据类型
     */
    private List<String> getType;
    /**
     *  添加数据类型
     */
    private String addType;
    /**
     *  更新数据类型
     */
    private String updateType;
    /**
     *  删除数据类型
     */
    private String deleteType;

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
        String methodName = joinPoint.getSignature().getName();
        if (getType.stream().anyMatch(methodName::startsWith)) {
            systemLog.setType(GET_NUM);
        } else if (methodName.startsWith(addType)) {
            systemLog.setType(ADD_NUM);
        } else if (methodName.startsWith(deleteType)) {
            systemLog.setType(DELETE_NUM);
        } else if (methodName.startsWith(updateType)) {
            systemLog.setType(UPDATE_NUM);
        } else {
            systemLog.setType(null);
        }
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
        systemLog.setOperator(SecurityContextHolder.getContext().getAuthentication().getName());
        systemLogService.addSystemLogService(systemLog);
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

    public String getAddType() {
        return addType;
    }

    public void setAddType(String addType) {
        this.addType = addType;
    }

    public String getUpdateType() {
        return updateType;
    }

    public void setUpdateType(String updateType) {
        this.updateType = updateType;
    }

    public String getDeleteType() {
        return deleteType;
    }

    public void setDeleteType(String deleteType) {
        this.deleteType = deleteType;
    }

    public List<String> getGetType() {
        return getType;
    }

    public void setGetType(List<String> getType) {
        this.getType = getType;
    }
}
