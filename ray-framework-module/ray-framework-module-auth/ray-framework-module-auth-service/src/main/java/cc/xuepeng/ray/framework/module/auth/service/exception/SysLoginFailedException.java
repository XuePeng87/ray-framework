package cc.xuepeng.ray.framework.module.auth.service.exception;

import cc.xuepeng.ray.framework.core.common.exception.BaseException;

/**
 * 登录系统失败的异常类
 *
 * @author xuepeng
 */
public class SysLoginFailedException extends BaseException {

    /**
     * 构造函数
     */
    public SysLoginFailedException() {
    }

    /**
     * 构造函数
     *
     * @param msg 异常信息
     */
    public SysLoginFailedException(String msg) {
        super(msg);
    }

    /**
     * 构造函数
     *
     * @param cause 异常原因
     */
    public SysLoginFailedException(Throwable cause) {
        super(cause);
    }

    /**
     * 构造函数
     *
     * @param msg   异常信息
     * @param cause 异常原因
     */
    public SysLoginFailedException(String msg, Throwable cause) {
        super(msg, cause);
    }

}
