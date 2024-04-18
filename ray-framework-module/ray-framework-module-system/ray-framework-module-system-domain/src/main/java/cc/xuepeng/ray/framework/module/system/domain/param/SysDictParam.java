package cc.xuepeng.ray.framework.module.system.domain.param;

import cc.xuepeng.ray.framework.core.model.param.BaseParam;
import cc.xuepeng.ray.framework.core.model.param.ParamValidateScope;
import cc.xuepeng.ray.framework.module.system.domain.enums.SysDictStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.validator.constraints.Length;

/**
 * 系统字典的数据请求类
 *
 * @author xuepeng
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class SysDictParam extends BaseParam implements ParamValidateScope {

    /**
     * 名称
     */
    @NotBlank(message = "名称不能为空", groups = {create.class, update.class})
    @Length(max = 32, message = "名称大于32个字符", groups = {create.class, update.class})
    private String name;

    /**
     * 编号
     */
    @NotBlank(message = "编号不能为空", groups = {create.class, update.class})
    @Length(max = 32, message = "编号大于32个字符", groups = {create.class, update.class})
    private String code;

    /**
     * 状态：0=停用；1=启用
     */
    @NotNull(message = "状态不能为空", groups = {create.class, update.class})
    private SysDictStatus status;

    /**
     * 描述
     */
    @Length(max = 256, message = "描述大于32个字符", groups = {create.class, update.class})
    private String remark;

}
