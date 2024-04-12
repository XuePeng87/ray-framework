package cc.xuepeng.ray.framework.core.auth.annotation;

import cc.xuepeng.ray.framework.core.auth.model.CurrentUser;
import cc.xuepeng.ray.framework.core.auth.service.AuthService;
import cc.xuepeng.ray.framework.core.model.dto.BaseDto;
import jakarta.annotation.Resource;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 设置创建人的切面类
 * 用于在方法调用时，获取当前登录人，用作CreateUser注解
 *
 * @author xuepeng
 */
@Component
@Aspect
public class CreateUserAspect {

    /**
     * 设置创建人
     */
    @Pointcut("@annotation(cc.xuepeng.ray.framework.core.auth.annotation.CreateUser)")
    private void createUser() {
        // 设置创建人
    }

    /**
     * 设置本次操作的创建人
     *
     * @param joinPoint 连接点
     */
    @Before("createUser()")
    public void doBefore(final JoinPoint joinPoint) {
        for (final Object arg : joinPoint.getArgs()) {
            if (arg instanceof BaseDto dto && authService.isLogin()) {
                final CurrentUser currentUser = authService.getCurrentUser();
                dto.setCreateUser(currentUser.getUserCode());
                dto.setModifyUser(currentUser.getUserCode());
            }
        }
    }

    /**
     * 身份认证业务处理接口
     */
    @Resource
    private AuthService authService;

}
