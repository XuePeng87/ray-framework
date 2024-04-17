package cc.xuepeng.ray.framework.core.web.log.domain.vo;

import cc.xuepeng.ray.framework.core.model.vo.BaseVo;
import lombok.*;

/**
 * 系统操作日志详情的响应类
 *
 * @author xuepeng
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class SysOperateLogDetailVo extends BaseVo {

    /**
     * 主键
     */
    private Long id;

    /**
     * 日志主键
     */
    private Long logId;

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
