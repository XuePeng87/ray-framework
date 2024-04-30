package cc.xuepeng.ray.framework.module.system.service.exception.func;

import cc.xuepeng.ray.framework.core.common.exception.BaseException;

/**
 * 系统功能已存在的异常类
 *
 * @author xuepeng
 */
public class SysFuncDuplicateException extends BaseException {

    /**
     * 构造函数
     */
    public SysFuncDuplicateException() {
    }

    /**
     * 构造函数
     *
     * @param msg 异常信息
     */
    public SysFuncDuplicateException(String msg) {
        super(msg);
    }

    /**
     * 构造函数
     *
     * @param cause 异常原因
     */
    public SysFuncDuplicateException(Throwable cause) {
        super(cause);
    }

    /**
     * 构造函数
     *
     * @param msg   异常信息
     * @param cause 异常原因
     */
    public SysFuncDuplicateException(String msg, Throwable cause) {
        super(msg, cause);
    }

}
