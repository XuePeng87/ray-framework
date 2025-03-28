package cc.xuepeng.ray.framework.core.common.domain.request;

import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 请求参数的父类
 *
 * @author xuepeng
 */
@Data
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class BaseRequest implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 开始创建时间
     */
    private LocalDateTime beginCreateTime;

    /**
     * 结束创建时间
     */
    private LocalDateTime endCreateTime;

    /**
     * 开始修改时间
     */
    private LocalDateTime beginModifyTime;

    /**
     * 结束修改时间
     */
    private LocalDateTime endModifyTime;

    /**
     * 当前页数
     */
    private Integer offset;

    /**
     * 每页记录数
     */
    private Integer limit;

    /**
     * 排序字段
     */
    private String sort;

    /**
     * 排序规则
     */
    private String order;

}
