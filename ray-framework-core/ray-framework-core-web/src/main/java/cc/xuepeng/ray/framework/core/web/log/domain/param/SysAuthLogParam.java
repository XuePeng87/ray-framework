package cc.xuepeng.ray.framework.core.web.log.domain.param;

import cc.xuepeng.ray.framework.core.model.param.BaseParam;
import cc.xuepeng.ray.framework.core.model.param.ParamValidateScope;
import cc.xuepeng.ray.framework.core.web.log.enums.SysAuthLogType;
import lombok.*;
import org.hibernate.validator.constraints.Length;

/**
 * 系统登录登出日志请求类
 *
 * @author xuepeng
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class SysAuthLogParam extends BaseParam implements ParamValidateScope {

    /**
     * 日志类型：1=登录日志；2=登出日志
     */
    private SysAuthLogType type;

    /**
     * 请求IP。
     */
    @Length(max = 32, message = "请求IP长度不能大于32个字符", groups = {page.class})
    private String loginIp;

}
