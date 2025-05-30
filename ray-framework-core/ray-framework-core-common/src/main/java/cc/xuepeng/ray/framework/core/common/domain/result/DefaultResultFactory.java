package cc.xuepeng.ray.framework.core.common.domain.result;

import java.util.HashMap;
import java.util.Map;

/**
 * Result的简单工厂类
 * 提供常用的返回Result的方法
 *
 * @author xuepeng
 */
public class DefaultResultFactory {

    /**
     * 构造函数
     */
    private DefaultResultFactory() {
    }

    /**
     * 默认的Data数据结构
     */
    private static final Map<String, String> DEFAULT_DATA = new HashMap<>();

    /**
     * 默认的Msg数据
     */
    private static final String DEFAULT_MSG = "";

    /**
     * 创建成功的Result对象
     *
     * @return 成功的Result对象
     */
    public static Result<Map<String, String>> success() {
        return success(DEFAULT_MSG);
    }

    /**
     * 创建成功的Result对象
     *
     * @param msg 返回的消息
     * @return 成功的Result对象
     */
    public static Result<Map<String, String>> success(final String msg) {
        return new Result.Builder<Map<String, String>>(DefaultResultStatus.SUCCESS)
                .msg(msg)
                .data(DEFAULT_DATA).build();
    }

    /**
     * 创建成功的Result对象
     *
     * @param msg  返回的消息
     * @param data 返回的数据
     * @return 成功的Result对象
     */
    public static <T> Result<T> success(final String msg, final T data) {
        return new Result.Builder<T>(DefaultResultStatus.SUCCESS)
                .msg(msg)
                .data(data)
                .build();
    }

    /**
     * 创建成功的Result对象
     *
     * @param data 返回的数据
     * @return 成功的Result对象
     */
    public static <T> Result<T> success(final T data) {
        return new Result.Builder<T>(DefaultResultStatus.SUCCESS)
                .msg(DefaultResultStatus.SUCCESS.name().toLowerCase())
                .data(data)
                .build();
    }

    /**
     * 创建失败的Result对象
     *
     * @return 失败的Result对象
     */
    public static Result<Map<String, String>> fail() {
        return fail(DEFAULT_MSG);
    }

    /**
     * 创建失败的Result对象
     *
     * @param msg 返回的消息
     * @return 失败的Result对象
     */
    public static Result<Map<String, String>> fail(final String msg) {
        return new Result.Builder<Map<String, String>>(DefaultResultStatus.FAIL)
                .msg(msg)
                .data(DEFAULT_DATA).build();
    }

    /**
     * 创建失败的Result对象
     *
     * @param msg  返回的消息
     * @param data 返回的数据
     * @return 失败的Result对象
     */
    public static <T> Result<T> fail(final String msg, final T data) {
        return new Result.Builder<T>(DefaultResultStatus.FAIL)
                .msg(msg)
                .data(data)
                .build();
    }

    /**
     * 创建系统异常的Result对象
     *
     * @return 系统异常的Result对象
     */
    public static Result<Map<String, String>> error() {
        return error(DEFAULT_MSG);
    }

    /**
     * 创建系统异常的Result对象
     *
     * @param msg 返回的消息
     * @return 系统异常的Result对象
     */
    public static Result<Map<String, String>> error(final String msg) {
        return new Result.Builder<Map<String, String>>(DefaultResultStatus.ERROR)
                .msg(msg)
                .data(DEFAULT_DATA).build();
    }

    /**
     * 创建系统异常的Result对象
     *
     * @param msg  返回的消息
     * @param data 返回的数据
     * @return 系统异常的Result对象
     */
    public static <T> Result<T> error(final String msg, final T data) {
        return new Result.Builder<T>(DefaultResultStatus.ERROR).
                msg(msg)
                .data(data)
                .build();
    }

}
