package cc.xuepeng.ray.framework.core.web.log.domain.param;

import cc.xuepeng.ray.framework.core.model.param.BaseParam;
import cc.xuepeng.ray.framework.core.model.param.ParamValidateScope;
import lombok.*;
import org.hibernate.validator.constraints.Length;

/**
 * 系统操作日志的请求类
 *
 * @author xuepeng
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class SysOperateLogParam extends BaseParam implements ParamValidateScope {

    /**
     * 模块名称
     */
    @Length(max = 16, message = "模块名称不能大于16个字符", groups = {page.class})
    private String module;

}
