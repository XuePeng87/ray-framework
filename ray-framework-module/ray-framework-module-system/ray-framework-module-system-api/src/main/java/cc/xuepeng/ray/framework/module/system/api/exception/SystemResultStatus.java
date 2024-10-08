package cc.xuepeng.ray.framework.module.system.api.exception;

import cc.xuepeng.ray.framework.core.model.result.ResultStatus;

/**
 * 系统管理异常响应状态
 *
 * @author xuepeng
 */
public enum SystemResultStatus implements ResultStatus {

    /**
     * SysDictDuplicateException的状态
     */
    DICT_DUPLICATE(50010, "字典已存在"),

    /**
     * SysDictNotFoundException的状态
     */
    DICT_NOT_FOUND(50011, "字典不存在"),

    /**
     * SysDictItemDuplicateException的状态
     */
    DICT_ITEM_DUPLICATE(50012, "字典项已存在"),

    /**
     * SysDictItemNotFoundException的状态
     */
    DICT_ITEM_NOT_FOUND(50013, "字典项不存在"),

    /**
     * SysDeptDuplicateException的状态
     */
    DEPT_DUPLICATE(50020, "部门已存在"),

    /**
     * SysDeptNotFoundException的状态
     */
    DEPT_NOT_FOUND(50021, "部门不存在"),

    /**
     * SysFuncDuplicationException的状态
     */
    FUNC_DUPLICATE(50030, "功能已存在"),

    /**
     * SysFuncNotFoundException的状态
     */
    FUNC_NOT_FOUND(50031, "功能不存在"),

    /**
     * SysFuncCannotDeleteException的状态
     */
    FUNC_CANNOT_DELETE(50032, "功能不能删除");


    /**
     * 构造函数
     *
     * @param code 状态编号
     * @param desc 状态描述
     */
    SystemResultStatus(final int code, final String desc) {
        this.code = code;
        this.desc = desc;
    }

    /**
     * @return 获取状态编号
     */
    @Override
    public int getCode() {
        return code;
    }

    /**
     * @return 获取状态描述
     */
    @Override
    public String getDesc() {
        return desc;
    }

    /**
     * 状态编号
     */
    private final int code;

    /**
     * 状态描述
     */
    private final String desc;

}
