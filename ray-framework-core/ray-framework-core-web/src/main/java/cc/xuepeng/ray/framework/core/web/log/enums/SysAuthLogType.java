package cc.xuepeng.ray.framework.core.web.log.enums;

import cc.xuepeng.ray.framework.core.model.enums.BaseEnum;
import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**
 * 认证日志类型
 *
 * @author xuepeng
 */
@Getter
@ToString
@AllArgsConstructor
public enum SysAuthLogType implements BaseEnum {

    LOGIN(1, "登录日志"),

    LOGOUT(2, "登出日志");

    /**
     * 枚举编号
     */
    @EnumValue
    private final Integer code;

    /**
     * 枚举描述
     */
    private final String desc;

}
