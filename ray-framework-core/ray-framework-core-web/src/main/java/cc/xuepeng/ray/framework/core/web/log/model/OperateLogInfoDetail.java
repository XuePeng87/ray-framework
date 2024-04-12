package cc.xuepeng.ray.framework.core.web.log.model;

import lombok.*;

import java.io.Serial;
import java.io.Serializable;

/**
 * 操作日志详情的实体类
 *
 * @author xuepeng
 */
@Data
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class OperateLogInfoDetail implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 请求路径参数
     */
    private String param;

    /**
     * 请求方法参数
     */
    private String args;

    /**
     * 返回值
     */
    private String result;

    /**
     * 错误信息
     */
    private String error;

}
