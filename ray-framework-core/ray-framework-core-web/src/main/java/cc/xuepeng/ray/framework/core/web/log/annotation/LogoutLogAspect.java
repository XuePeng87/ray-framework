package cc.xuepeng.ray.framework.core.web.log.annotation;

import cc.xuepeng.ray.framework.core.auth.model.CurrentUser;
import cc.xuepeng.ray.framework.core.auth.service.AuthService;
import cc.xuepeng.ray.framework.core.common.util.ThreadLocalUtil;
import cc.xuepeng.ray.framework.core.web.log.domain.dto.SysAuthLogDto;
import cc.xuepeng.ray.framework.core.web.log.enums.SysAuthLogType;
import cc.xuepeng.ray.framework.core.web.log.service.SysAuthLogService;
import cc.xuepeng.ray.framework.core.web.log.util.UserAgentInfoUtil;
import cc.xuepeng.ray.framework.core.web.util.WebUtil;
import cn.hutool.core.date.LocalDateTimeUtil;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
 * 登出日志的切面类
 *
 * @author xuepeng
 */
@Component
@Aspect
@Slf4j
public class LogoutLogAspect {

    /**
     * ThreadLocal中的Key
     */
    private static final String THREAD_LOCAL_KEY = "LogoutLog";

    /**
     * 对注解修饰的方法进行切面处理
     */
    @Pointcut(value = "@annotation(cc.xuepeng.ray.framework.core.web.log.annotation.LogoutLog)")
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
        final SysAuthLogDto sysAuthLogDto = new SysAuthLogDto();
        UserAgentInfoUtil.setUserAgentInfo(sysAuthLogDto, request);
        sysAuthLogDto.setCreateTime(LocalDateTime.now());
        sysAuthLogDto.setLoginIp(WebUtil.getIPAddress(request));
        if (authService.isLogin()) {
            final CurrentUser currentUser = authService.getCurrentUser();
            sysAuthLogDto.setCreateUser(currentUser.getUserCode());
        }
        // 保存封装信息到ThreadLocal中
        ThreadLocalUtil.put(THREAD_LOCAL_KEY, sysAuthLogDto);
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
            final SysAuthLogDto sysAuthLogDto = (SysAuthLogDto) ThreadLocalUtil.getAndRemove(THREAD_LOCAL_KEY);
            final long exeTime = LocalDateTimeUtil.between(
                    sysAuthLogDto.getCreateTime(), LocalDateTime.now(), ChronoUnit.MILLIS
            );
            sysAuthLogDto.setExeTime(exeTime);
            sysAuthLogDto.setType(SysAuthLogType.LOGOUT);
            sysAuthLogService.create(sysAuthLogDto);
        } catch (Exception e) {
            log.error("保存登出日志失败：{}", e.getMessage());
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
        ThreadLocalUtil.remove(THREAD_LOCAL_KEY);
    }

    /**
     * 认证的业务处理接口
     */
    @Resource
    private AuthService authService;

    /**
     * 登录日志持久化接口
     */
    @Resource
    private SysAuthLogService sysAuthLogService;

}
