package cc.xuepeng.ray.framework.core.web.log.model;

import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 操作日志的实体类
 *
 * @author xuepeng
 */
@Data
@ToString
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class OperateLogInfo extends BaseLogInfo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 操作人
     */
    private String createUser;

    /**
     * 操作时间
     */
    private LocalDateTime createTime;

    /**
     * 模块名称
     */
    private String module;

    /**
     * 功能名称
     */
    private String func;

    /**
     * 功能描述
     */
    private String remark;

    /**
     * 动作描述
     */
    private String action;

    /**
     * 请求IP
     */
    private String ip;

    /**
     * 请求Url
     */
    private String url;

    /**
     * 请求Uri
     */
    private String uri;

    /**
     * 请求Method
     */
    private String method;

    /**
     * 请求类名
     */
    private String className;

    /**
     * 请求方法名
     */
    private String methodName;

    /**
     * 操作时间
     */
    private Long exeTime;

    /**
     * 详细信息
     */
    private OperateLogInfoDetail detail = new OperateLogInfoDetail();

}
