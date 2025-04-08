package cc.xuepeng.ray.framework.module.common.log.annotation;

import cc.xuepeng.ray.framework.core.common.consts.PunctuationConst;
import cc.xuepeng.ray.framework.core.common.util.ThreadLocalUtil;
import cc.xuepeng.ray.framework.core.web.util.WebUtil;
import cc.xuepeng.ray.framework.module.common.log.domain.dto.SysOperateLogDto;
import cc.xuepeng.ray.framework.module.common.log.enums.SysOperateLogType;
import cc.xuepeng.ray.framework.module.common.log.service.SysOperateLogService;
import cc.xuepeng.ray.framework.module.common.log.util.UserAgentInfoUtil;
import cc.xuepeng.ray.framework.sdk.auth.model.CurrentUser;
import cc.xuepeng.ray.framework.sdk.auth.service.IdentificationService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Map;

/**
 * 系统操作日志的切面类
 *
 * @author xuepeng
 */
@Slf4j
@Aspect
@Component
public class OperateLogAspect {

    /**
     * 请求开始时间在ThreadLocal中的Key
     */
    private static final String THREAD_LOCAL_KEY = "OperateLogInfo";

    /**
     * 对被系统操作日志注解修饰的方法进行切面处理
     */
    @Pointcut(value = "@annotation(cc.xuepeng.ray.framework.module.common.log.annotation.OperateLog)")
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
        final SysOperateLogDto sysOperateLogDto = new SysOperateLogDto();
        UserAgentInfoUtil.setUserAgentInfo(sysOperateLogDto, request);
        // 封装Request信息
        setRequestInfo(sysOperateLogDto, request, joinPoint);
        // 封装注解信息
        setAnnotationInfo(sysOperateLogDto, method.getAnnotation(OperateLog.class));
        // 保存封装信息到ThreadLocal中
        ThreadLocalUtil.put(THREAD_LOCAL_KEY, sysOperateLogDto);
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
            final SysOperateLogDto sysOperateLogDto = (SysOperateLogDto) ThreadLocalUtil.getAndRemove(THREAD_LOCAL_KEY);
            // 设置认证信息
            setAuthInfo(sysOperateLogDto);
            if (ObjectUtils.isNotEmpty(result)) {
                sysOperateLogDto.getDetail().setResult(result.toString());
            }
            sysOperateLogDto.setType(SysOperateLogType.ACCESS);
            sysOperateLogDto.setExeTime(exeTime(sysOperateLogDto.getCreateTime()));
            // 持久化访问日志
            if (isPersistent(joinPoint)) {
                sysOperateLogService.create(sysOperateLogDto);
            }
            log.info(sysOperateLogDto.toString());
        } catch (Exception e) {
            log.error("保存系统操作日志失败：{}", e.getMessage());
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
            final SysOperateLogDto sysOperateLogDto = (SysOperateLogDto) ThreadLocalUtil.getAndRemove(THREAD_LOCAL_KEY);
            // 设置认证信息
            setAuthInfo(sysOperateLogDto);
            sysOperateLogDto.getDetail().setError(throwable.getMessage());
            sysOperateLogDto.setType(SysOperateLogType.ERROR);
            sysOperateLogDto.setExeTime(exeTime(sysOperateLogDto.getCreateTime()));
            log.error(sysOperateLogDto.toString(), throwable);
            // 持久化错误日志
            if (isPersistent(joinPoint)) {
                sysOperateLogService.create(sysOperateLogDto);
            }
        } catch (Exception e) {
            log.error("保存错误日志失败：{}", e.getMessage());
        } finally {
            ThreadLocalUtil.remove(THREAD_LOCAL_KEY);
        }
    }

    /**
     * 设置系统操作日志的认证信息
     *
     * @param sysOperateLogDto 系统操作日志数的据传输对象
     */
    private void setAuthInfo(final SysOperateLogDto sysOperateLogDto) {
        // 设置用户信息
        if (identificationService.isLogin()) {
            final CurrentUser currentUser = identificationService.getCurrentUser();
            sysOperateLogDto.setCreateUser(currentUser.getCode());
            sysOperateLogDto.setPhoneNumber(currentUser.getPhoneNumber());
        }
    }

    /**
     * 设置Request信息
     *
     * @param sysOperateLogDto 系统操作日志数的据传输对象
     * @param request          请求对象
     * @param joinPoint        连接点对象
     */
    private void setRequestInfo(final SysOperateLogDto sysOperateLogDto,
                                final HttpServletRequest request,
                                final JoinPoint joinPoint) {
        // 请求信息
        sysOperateLogDto.setCreateTime(LocalDateTime.now());
        sysOperateLogDto.setUrl(request.getRequestURL().toString());
        sysOperateLogDto.setUri(request.getRequestURI());
        sysOperateLogDto.setMethod(request.getMethod());
        sysOperateLogDto.setIp(WebUtil.getIPAddress(request));
        sysOperateLogDto.setClassName(joinPoint.getTarget().getClass().getName());
        // API Params信息
        final StringBuilder params = new StringBuilder();
        final Map<String, String[]> parameterMap = request.getParameterMap();
        parameterMap.forEach((k, v) -> params
                .append(k)
                .append(PunctuationConst.EQUAL)
                .append(v[0])
                .append(PunctuationConst.SEMICOLON)
        );
        if (StringUtils.isNotBlank(params)) {
            sysOperateLogDto.getDetail().setParam(params.toString());
        }
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
        if (StringUtils.isNotBlank(args)) {
            sysOperateLogDto.getDetail().setArgs(args.toString());
        }
    }

    /**
     * 设置注解信息
     *
     * @param sysOperateLogDto 系统操作日志的数据传输对象
     * @param operateLog       系统操作日志注解
     */
    private void setAnnotationInfo(final SysOperateLogDto sysOperateLogDto, final OperateLog operateLog) {
        sysOperateLogDto.setModule(operateLog.module());
        sysOperateLogDto.setFunc(operateLog.func());
        sysOperateLogDto.setRemark(operateLog.remark());
        sysOperateLogDto.setAction(operateLog.action().name());
    }

    /**
     * 系统操作日志是否需要持久化
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
        final Duration exeTime = Duration.between(startTime, LocalDateTime.now());
        return exeTime.toMillis();
    }

    /**
     * 认证的业务处理接口
     */
    @Resource
    private IdentificationService identificationService;

    /**
     * 系统操作日志持久化接口
     */
    @Resource
    private SysOperateLogService sysOperateLogService;

}
