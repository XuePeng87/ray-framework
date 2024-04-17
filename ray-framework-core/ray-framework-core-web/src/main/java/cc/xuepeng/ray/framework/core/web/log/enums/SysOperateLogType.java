package cc.xuepeng.ray.framework.core.web.log.enums;

import cc.xuepeng.ray.framework.core.model.enums.BaseEnum;
import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**
 * 操作日志类型
 *
 * @author xuepeng
 */
@Getter
@ToString
@AllArgsConstructor
public enum SysOperateLogType implements BaseEnum {

    ACCESS(1, "操作日志"),

    ERROR(2, "错误日志");

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
