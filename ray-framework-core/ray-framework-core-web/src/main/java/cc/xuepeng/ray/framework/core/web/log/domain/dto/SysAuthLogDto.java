package cc.xuepeng.ray.framework.core.web.log.domain.dto;

import cc.xuepeng.ray.framework.core.model.dto.BaseDto;
import cc.xuepeng.ray.framework.core.web.log.enums.SysAuthLogType;
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
public class SysAuthLogDto extends BaseDto {

    /**
     * 日志类型：1=登录日志；2=登出日志
     */
    private SysAuthLogType type;

    /**
     * 登录IP地址
     */
    private String loginIp;

    /**
     * 登录人
     */
    private String userCode;

    /**
     * 浏览器
     */
    private String browser;

    /**
     * 浏览器版本
     */
    private String browserVersion;

    /**
     * 平台
     */
    private String platform;

    /**
     * 操作系统
     */
    private String os;

    /**
     * 操作系统版本
     */
    private String osVersion;

    /**
     * 引擎
     */
    private String engine;

    /**
     * 引擎版本
     */
    private String engineVersion;

    /**
     * 操作时间
     */
    private Long exeTime;

}
