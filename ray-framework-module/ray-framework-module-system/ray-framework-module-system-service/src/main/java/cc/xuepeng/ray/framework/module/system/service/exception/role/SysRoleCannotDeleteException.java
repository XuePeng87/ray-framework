package cc.xuepeng.ray.framework.module.system.service.exception.role;

import cc.xuepeng.ray.framework.core.common.exception.BaseException;

/**
 * 系统角色不能删除的异常类
 *
 * @author xuepeng
 */
public class SysRoleCannotDeleteException extends BaseException {

    /**
     * 构造函数
     */
    public SysRoleCannotDeleteException() {
    }

    /**
     * 构造函数
     *
     * @param msg 异常信息
     */
    public SysRoleCannotDeleteException(String msg) {
        super(msg);
    }

    /**
     * 构造函数
     *
     * @param cause 异常原因
     */
    public SysRoleCannotDeleteException(Throwable cause) {
        super(cause);
    }

    /**
     * 构造函数
     *
     * @param msg   异常信息
     * @param cause 异常原因
     */
    public SysRoleCannotDeleteException(String msg, Throwable cause) {
        super(msg, cause);
    }

}
