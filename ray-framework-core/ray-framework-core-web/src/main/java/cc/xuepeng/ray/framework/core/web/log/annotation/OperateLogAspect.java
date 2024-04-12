package cc.xuepeng.ray.framework.core.web.log.annotation;

import cc.xuepeng.ray.framework.core.auth.model.CurrentUser;
import cc.xuepeng.ray.framework.core.auth.service.AuthService;
import cc.xuepeng.ray.framework.core.common.consts.PunctuationConst;
import cc.xuepeng.ray.framework.core.common.util.ThreadLocalUtil;
import cc.xuepeng.ray.framework.core.web.log.dao.OperateLogDao;
import cc.xuepeng.ray.framework.core.web.log.model.OperateLogInfo;
import cc.xuepeng.ray.framework.core.web.util.WebUtil;
import cn.hutool.core.date.LocalDateTimeUtil;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Map;

/**
 * 操作日志的切面类
 *
 * @author xuepeng
 */
@Component
@Aspect
@Slf4j
public class OperateLogAspect {

    /**
     * 请求开始时间在ThreadLocal中的Key
     */
    private static final String THREAD_LOCAL_KEY = "OperateLogInfo";

    /**
     * 对被操作日志注解修饰的方法进行切面处理
     */
    @Pointcut(value = "@annotation(cc.xuepeng.ray.framework.core.web.log.annotation.OperateLog)")
    private void operation() {
        // 对请求进行切面处理
    }

    /**
     * 方法执行前的处理
     *
     * @param joinPoint 连接点
     */
    @Before("operation()")
    public void doBefore(JoinPoint joinPoint) {
        // 获取本次请求的元数据
        final HttpServletRequest request = WebUtil.getHttpServletRequest();
        final Method method = ((MethodSignature) joinPoint.getSignature()).getMethod();
        OperateLogInfo operateLogInfo = new OperateLogInfo();
        operateLogInfo.setUserAgentInfo(request);
        // 封装Request信息
        setRequestInfo(operateLogInfo, request, joinPoint);
        // 封装注解信息
        setAnnotationInfo(operateLogInfo, method.getAnnotation(OperateLog.class));
        // 保存封装信息到ThreadLocal中
        ThreadLocalUtil.put(THREAD_LOCAL_KEY, operateLogInfo);
    }

    /**
     * 方法返回后的处理
     *
     * @param joinPoint 连接点
     * @param result    返回值
     */
    @AfterReturning(value = "operation()", returning = "result")
    public void doAfterReturning(JoinPoint joinPoint, Object result) {
        try {
            final OperateLogInfo operateLogInfo = (OperateLogInfo) ThreadLocalUtil.getAndRemove(THREAD_LOCAL_KEY);
            // 设置认证信息
            setAuthInfo(operateLogInfo);
            if (ObjectUtils.isNotEmpty(result)) {
                operateLogInfo.getDetail().setResult(result.toString());
            }
            operateLogInfo.setExeTime(exeTime(operateLogInfo.getCreateTime()));
            // 持久化访问日志
            if (isPersistent(joinPoint)) {
                operateLogDao.saveAccessLog(operateLogInfo);
            }
        } catch (Exception e) {
            log.error("保存操作日志失败：{}", e.getMessage());
        } finally {
            ThreadLocalUtil.remove(THREAD_LOCAL_KEY);
        }
    }

    /**
     * 方法异常后的处理
     *
     * @param joinPoint 连接点
     * @param throwable 异常
     */
    @AfterThrowing(pointcut = "operation()", throwing = "throwable")
    public void doAfterThrowing(JoinPoint joinPoint, Throwable throwable) {
        try {
            final OperateLogInfo operateLogInfo = (OperateLogInfo) ThreadLocalUtil.getAndRemove(THREAD_LOCAL_KEY);
            // 设置认证信息
            setAuthInfo(operateLogInfo);
            operateLogInfo.getDetail().setError(throwable.getMessage());
            operateLogInfo.setExeTime(exeTime(operateLogInfo.getCreateTime()));
            log.error(operateLogInfo.toString(), throwable);
            // 持久化错误日志
            if (isPersistent(joinPoint)) {
                operateLogDao.saveErrorLog(operateLogInfo);
            }
        } catch (Exception e) {
            log.error("保存错误日志失败：{}", e.getMessage());
        } finally {
            ThreadLocalUtil.remove(THREAD_LOCAL_KEY);
        }
    }

    /**
     * 设置操作日志的认证信息
     *
     * @param operateLogInfo 操作日志信息
     */
    private void setAuthInfo(final OperateLogInfo operateLogInfo) {
        // 设置用户信息
        if (authService.isLogin()) {
            final CurrentUser currentUser = authService.getCurrentUser();
            operateLogInfo.setCreateUser(currentUser.getUserAccount());
        }
    }

    /**
     * 设置Request信息
     *
     * @param operateLogInfo 操作日志信息
     * @param request        请求对象
     * @param joinPoint      连接点对象
     */
    private void setRequestInfo(final OperateLogInfo operateLogInfo,
                                final HttpServletRequest request,
                                final JoinPoint joinPoint) {
        // 请求信息
        operateLogInfo.setCreateTime(LocalDateTime.now());
        operateLogInfo.setUrl(request.getRequestURL().toString());
        operateLogInfo.setUri(request.getRequestURI());
        operateLogInfo.setMethod(request.getMethod());
        operateLogInfo.setIp(WebUtil.getIPAddress(request));
        operateLogInfo.setClassName(joinPoint.getTarget().getClass().getName());
        // API Params信息
        final StringBuilder params = new StringBuilder();
        final Map<String, String[]> parameterMap = request.getParameterMap();
        parameterMap.forEach((k, v) -> params
                .append(k)
                .append(PunctuationConst.EQUAL)
                .append(v[0])
                .append(PunctuationConst.SEMICOLON)
        );
        operateLogInfo.getDetail().setParam(params.toString());
        // API Args信息
        final StringBuilder args = new StringBuilder();
        for (int i = 0; i < joinPoint.getArgs().length; i++) {
            args.append(PunctuationConst.LEFT_SQUARE_BRACKETS)
                    .append("arg")
                    .append(i)
                    .append(PunctuationConst.COLON)
                    .append(joinPoint.getArgs()[i])
                    .append(PunctuationConst.RIGHT_SQUARE_BRACKETS);
        }
        operateLogInfo.getDetail().setArgs(args.toString());
    }

    /**
     * 设置注解信息
     *
     * @param operateLogInfo 操作日志信息
     * @param operateLog     操作日志注解
     */
    private void setAnnotationInfo(final OperateLogInfo operateLogInfo, final OperateLog operateLog) {
        operateLogInfo.setModule(operateLog.module());
        operateLogInfo.setFunc(operateLog.func());
        operateLogInfo.setRemark(operateLog.remark());
        operateLogInfo.setAction(operateLog.action().name());
    }

    /**
     * 操作日志是否需要持久化
     *
     * @param joinPoint 连接点
     * @return 是否需要持久化
     */
    private boolean isPersistent(JoinPoint joinPoint) {
        final Method method = ((MethodSignature) joinPoint.getSignature()).getMethod();
        return method.getAnnotation(OperateLog.class).persistent();
    }

    /**
     * @return 计算请求执行时间
     */
    public long exeTime(final LocalDateTime startTime) {
        return LocalDateTimeUtil.between(startTime, LocalDateTime.now(), ChronoUnit.MILLIS);
    }

    /**
     * 认证鉴权的业务处理接口
     */
    @Resource
    private AuthService authService;

    /**
     * 操作日志持久化接口
     */
    @Resource
    private OperateLogDao operateLogDao;

}
