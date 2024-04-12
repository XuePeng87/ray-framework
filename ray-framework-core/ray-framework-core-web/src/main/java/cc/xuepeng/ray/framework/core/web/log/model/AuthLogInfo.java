package cc.xuepeng.ray.framework.core.web.log.model;

import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 登录日志的实体类
 *
 * @author xuepeng
 */
@Data
@ToString
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class AuthLogInfo extends BaseLogInfo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 动作
     */
    private String action;

    /**
     * 登录时间
     */
    private LocalDateTime createTime;

    /**
     * 登录人
     */
    private String createUser;

    /**
     * 登录IP地址
     */
    private String loginIp;

    /**
     * 操作时间
     */
    private long exeTime;

}
