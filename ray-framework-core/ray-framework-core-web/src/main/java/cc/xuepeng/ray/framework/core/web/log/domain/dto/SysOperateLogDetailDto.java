package cc.xuepeng.ray.framework.core.web.log.domain.dto;

import cc.xuepeng.ray.framework.core.model.dto.BaseDto;
import lombok.*;

/**
 * 系统登录登出日志数据传输类
 *
 * @author xuepeng
 */
@Data
@ToString
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class SysOperateLogDetailDto extends BaseDto {

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
