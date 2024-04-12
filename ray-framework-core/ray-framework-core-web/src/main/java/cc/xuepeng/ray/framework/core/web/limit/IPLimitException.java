package cc.xuepeng.ray.framework.core.web.limit;

import cc.xuepeng.ray.framework.core.common.exception.BaseException;

/**
 * 接口限流的异常类
 *
 * @author xuepeng
 */
public class IPLimitException extends BaseException {

    /**
     * 构造函数
     */
    public IPLimitException() {
    }

    /**
     * 构造函数
     *
     * @param msg 异常信息
     */
    public IPLimitException(String msg) {
        super(msg);
    }

    /**
     * 构造函数
     *
     * @param cause 异常原因
     */
    public IPLimitException(Throwable cause) {
        super(cause);
    }

    /**
     * 构造函数
     *
     * @param msg   异常信息
     * @param cause 异常原因
     */
    public IPLimitException(String msg, Throwable cause) {
        super(msg, cause);
    }

}
