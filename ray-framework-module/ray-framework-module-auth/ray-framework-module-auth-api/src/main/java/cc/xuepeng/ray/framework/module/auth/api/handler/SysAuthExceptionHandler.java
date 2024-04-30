package cc.xuepeng.ray.framework.module.auth.api.handler;

import cc.xuepeng.ray.framework.core.model.result.Result;
import cc.xuepeng.ray.framework.module.auth.service.exception.SysLoginFailedException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 通用的异常处理类
 *
 * @author xuepeng
 */
@ControllerAdvice
@Slf4j
public class SysAuthExceptionHandler {

    /**
     * 登录失败的异常处理
     *
     * @param e 登录失败的异常对象
     * @return 错误信息
     */
    @ExceptionHandler(value = SysLoginFailedException.class)
    @ResponseBody
    public Result<String> sysLoginFailedException(SysLoginFailedException e) {
        log.error(e.getMessage());
        return new Result.Builder<String>(SysAuthResultStatus.LOGIN_LOCKED)
                .msg(e.getMessage())
                .build();
    }

}
