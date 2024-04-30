package cc.xuepeng.ray.framework.core.web.handler;

import cc.xuepeng.ray.framework.core.common.exception.CodecException;
import cc.xuepeng.ray.framework.core.common.exception.FileUtilException;
import cc.xuepeng.ray.framework.core.common.strategy.factory.SimpleFactoryObjectNotFoundException;
import cc.xuepeng.ray.framework.core.model.result.Result;
import cc.xuepeng.ray.framework.core.web.limit.IPLimitException;
import cc.xuepeng.ray.framework.core.web.security.file.FileValidatorException;
import cn.dev33.satoken.exception.NotLoginException;
import cn.dev33.satoken.exception.NotPermissionException;
import cn.dev33.satoken.exception.NotRoleException;
import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * 通用的异常处理类
 *
 * @author xuepeng
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    private static final String PARAM_ERROR_MSG = "接口参数验证失败";

    /**
     * API参数验证失败的异常处理
     * 处理RequestParam的参数错误
     * 错误码：400
     *
     * @param e API参数验证失败的异常对象
     * @return 错误信息
     */
    @ExceptionHandler(value = ConstraintViolationException.class)
    @ResponseBody
    public ResponseEntity<String> constraintViolationException(ConstraintViolationException e) {
        log.error(e.getMessage());
        final Result<String> result = new Result.Builder<String>(GlobalResultStatus.REQUEST_BAD)
                .msg(e.getMessage())
                .build();
        return new ResponseEntity<>(result.toString(), HttpStatus.BAD_REQUEST);
    }

    /**
     * API参数验证失败的异常处理
     * 处理RequestBody的参数错误
     * 错误码：400
     *
     * @param e API参数验证失败的异常对象
     * @return 错误信息
     */
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    @ResponseBody
    public ResponseEntity<String> methodArgumentNotValidException(MethodArgumentNotValidException e) {
        log.error(e.getMessage());
        final Result<Map<String, String>> result = new Result.Builder<Map<String, String>>(GlobalResultStatus.REQUEST_BAD)
                .msg(PARAM_ERROR_MSG)
                .build();
        return new ResponseEntity<>(result.toString(), HttpStatus.BAD_REQUEST);
    }

    /**
     * API参数验证失败的异常处理
     * 处理RequestParam中的参数错误
     * 错误码：400
     *
     * @param e API参数验证失败的异常对象
     * @return 错误信息
     */
    @ExceptionHandler(value = BindException.class)
    @ResponseBody
    public ResponseEntity<String> bindException(BindException e) {
        final Result<Map<String, String>> result = new Result.Builder<Map<String, String>>(GlobalResultStatus.REQUEST_BAD)
                .msg(PARAM_ERROR_MSG)
                .build();
        log.error(e.getMessage());
        return new ResponseEntity<>(result.toString(), HttpStatus.BAD_REQUEST);
    }

    /**
     * 文件校验失败的异常处理
     * 错误码：400
     *
     * @param e 文件校验失败的异常对象
     * @return 错误信息
     */
    @ExceptionHandler(value = FileValidatorException.class)
    @ResponseBody
    public ResponseEntity<String> fileValidatorException(FileValidatorException e) {
        final Result<String> result = new Result.Builder<String>(GlobalResultStatus.REQUEST_BAD)
                .msg(e.getMessage())
                .build();
        log.error(e.getMessage());
        return new ResponseEntity<>(result.toString(), HttpStatus.BAD_REQUEST);
    }

    /**
     * 系统认证失败的异常处理
     * 错误码：401
     *
     * @param e 未登录的异常对象
     * @return 错误信息
     */
    @ExceptionHandler(value = NotLoginException.class)
    @ResponseBody
    public ResponseEntity<String> notLoginException(NotLoginException e) {
        log.error(e.getMessage());
        String message = switch (e.getType()) {
            case NotLoginException.NOT_TOKEN -> NotLoginException.NOT_TOKEN_MESSAGE;
            case NotLoginException.INVALID_TOKEN -> NotLoginException.INVALID_TOKEN_MESSAGE;
            case NotLoginException.TOKEN_TIMEOUT -> NotLoginException.TOKEN_TIMEOUT_MESSAGE;
            case NotLoginException.BE_REPLACED -> NotLoginException.BE_REPLACED_MESSAGE;
            case NotLoginException.KICK_OUT -> NotLoginException.KICK_OUT_MESSAGE;
            case NotLoginException.TOKEN_FREEZE -> NotLoginException.TOKEN_FREEZE_MESSAGE;
            case NotLoginException.NO_PREFIX -> NotLoginException.NO_PREFIX_MESSAGE;
            default -> "当前会话未登录";
        };
        return new ResponseEntity<>(message, HttpStatus.UNAUTHORIZED);
    }

    /**
     * 触发IP限流时的异常处理
     * 错误码：402
     *
     * @param e IP限流异常信息对象
     * @return 错误信息
     */
    @ExceptionHandler(value = IPLimitException.class)
    @ResponseBody
    public ResponseEntity<String> ipLimitException(IPLimitException e) {
        log.error(e.getMessage());
        final Result<String> result = new Result.Builder<String>(GlobalResultStatus.REQUEST_LIMIT)
                .msg(e.getMessage())
                .build();
        return new ResponseEntity<>(result.toString(), HttpStatus.PAYMENT_REQUIRED);
    }

    /**
     * 系统鉴权失败的异常处理
     * 错误码：403
     *
     * @param e 无操作角色的异常对象
     * @return 错误信息
     */
    @ExceptionHandler(value = NotRoleException.class)
    @ResponseBody
    public ResponseEntity<String> notRoleException(NotRoleException e) {
        log.error(e.getMessage());
        return new ResponseEntity<>("无此角色", HttpStatus.FORBIDDEN);
    }

    /**
     * 系统鉴权失败的异常处理
     * 错误码：403
     *
     * @param e 无操作权限的异常对象
     * @return 错误信息
     */
    @ExceptionHandler(value = NotPermissionException.class)
    @ResponseBody
    public ResponseEntity<String> notPermissionException(NotPermissionException e) {
        log.error(e.getMessage());
        return new ResponseEntity<>("无此权限", HttpStatus.FORBIDDEN);
    }

    /**
     * Aes、Des、Rsa等算法执行过程中发生异常
     * 错误码：500
     *
     * @param e IP限流异常信息对象
     * @return 错误信息
     */
    @ExceptionHandler(value = CodecException.class)
    @ResponseBody
    public ResponseEntity<String> codecException(CodecException e) {
        log.error(e.getMessage(), e);
        return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     * 未匹配到指定策略
     * 错误码：500
     *
     * @param e 未匹配到指定策略异常信息对象
     * @return 错误信息
     */
    @ExceptionHandler(value = SimpleFactoryObjectNotFoundException.class)
    @ResponseBody
    public ResponseEntity<String> simpleFactoryObjectNotFoundException(SimpleFactoryObjectNotFoundException e) {
        log.error(e.getMessage(), e);
        return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     * 文件处理异常
     * 错误号：500
     *
     * @param e 文件处理异常信息对象
     * @return 错误信息
     */
    @ExceptionHandler(value = FileUtilException.class)
    @ResponseBody
    public ResponseEntity<String> fileUtilException(FileUtilException e) {
        log.error(e.getMessage(), e);
        return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
