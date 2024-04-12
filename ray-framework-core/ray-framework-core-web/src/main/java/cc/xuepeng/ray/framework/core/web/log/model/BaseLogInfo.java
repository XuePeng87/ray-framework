package cc.xuepeng.ray.framework.core.web.log.model;

import cc.xuepeng.ray.framework.core.web.util.WebUtil;
import cn.hutool.http.useragent.UserAgent;
import jakarta.servlet.http.HttpServletRequest;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;

/**
 * 日志信息父类
 *
 * @author xuepeng
 */
@Data
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class BaseLogInfo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

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
     * 设置UserAgent
     *
     * @param request 请求对象
     */
    public void setUserAgentInfo(final HttpServletRequest request) {
        final UserAgent userAgent = WebUtil.getUserAgent(request);
        this.browser = userAgent.getBrowser().getName();
        this.browserVersion = userAgent.getVersion();
        this.platform = userAgent.getPlatform().getName();
        this.os = userAgent.getOs().getName();
        this.osVersion = userAgent.getOsVersion();
        this.engine = userAgent.getEngine().getName();
        this.engineVersion = userAgent.getEngineVersion();
    }

}
