package cc.xuepeng.ray.framework.sdk.verifycode.enums;

import cc.xuepeng.ray.framework.core.model.enums.BaseEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**
 * 验证码类型
 *
 * @author xuepeng
 */
@Getter
@ToString
@AllArgsConstructor
public enum VerifyCodeType implements BaseEnum {

    IMAGE_LOGIN(1, "RAY:VC:LOGIN:");

    /**
     * 枚举值
     */
    private final Integer code;

    /**
     * 枚举描述
     */
    private final String prefix;

}
