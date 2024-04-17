package cc.xuepeng.ray.framework.core.auth.exception;

import cc.xuepeng.ray.framework.core.common.exception.BaseException;

/**
 * 未登录的异常类
 *
 * @author xuepeng
 */
public class NotLoginException extends BaseException {

    /**
     * 构造函数
     */
    public NotLoginException() {
    }

    /**
     * 构造函数
     *
     * @param msg 异常信息
     */
    public NotLoginException(String msg) {
        super(msg);
    }

    /**
     * 构造函数
     *
     * @param cause 异常原因
     */
    public NotLoginException(Throwable cause) {
        super(cause);
    }

    /**
     * 构造函数
     *
     * @param msg   异常信息
     * @param cause 异常原因
     */
    public NotLoginException(String msg, Throwable cause) {
        super(msg, cause);
    }

}
