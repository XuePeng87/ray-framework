package cc.xuepeng.ray.framework.core.common.domain.result;

import lombok.Data;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;

/**
 * Result的实体类
 *
 * @param <T> 返回数据
 * @author xuepeng
 */
@Data
@ToString
public class Result<T> implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 构造函数
     *
     * @param builder 建造者
     */
    private Result(final Builder<T> builder) {
        this.code = builder.status.getCode();
        this.desc = builder.status.getDesc();
        this.msg = builder.msg;
        this.data = builder.data;
    }

    /**
     * 状态码
     */
    private int code;

    /**
     * 状态码描述
     */
    private String desc;

    /**
     * 返回消息
     */
    private String msg;

    /**
     * 返回数据
     */
    private transient T data;

    /**
     * Result的构造器
     *
     * @author xuepeng
     */

    public static class Builder<K> {

        /**
         * 构造函数
         *
         * @param status 返回状态
         */
        public Builder(final ResultStatus status) {
            this.status = status;
        }

        /**
         * 设置返回消息
         *
         * @param msg 返回消息
         * @return Result.Builder对象
         */
        public Builder<K> msg(final String msg) {
            this.msg = msg;
            return this;
        }

        /**
         * 设置返回数据
         *
         * @param data 返回数据
         * @return Result.Builder对象
         */
        public Builder<K> data(final K data) {
            this.data = data;
            return this;
        }

        /**
         * 创建ResultEntity对象
         *
         * @return ResultEntity对象
         */
        public Result<K> build() {
            return new Result<>(this);
        }

        /**
         * 返回状态
         */
        private final ResultStatus status;

        /**
         * 返回消息
         */
        private String msg;

        /**
         * 返回数据
         */
        private K data;

    }

}
