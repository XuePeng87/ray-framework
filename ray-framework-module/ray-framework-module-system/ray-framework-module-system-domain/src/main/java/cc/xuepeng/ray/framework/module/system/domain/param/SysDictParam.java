package cc.xuepeng.ray.framework.module.system.domain.param;

import cc.xuepeng.ray.framework.core.model.param.BaseParam;
import cc.xuepeng.ray.framework.core.model.param.ParamValidateScope;
import cc.xuepeng.ray.framework.module.system.domain.enums.SysDictStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.validator.constraints.Length;

/**
 * 系统字典数据请求类
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
     * 字典名称
     */
    @NotBlank(message = "字典名称不能为空", groups = {create.class, update.class})
    @Length(max = 128, message = "字典名称大于128个字符", groups = {create.class, update.class})
    private String dictName;

    /**
     * 字段编号
     */
    @NotBlank(message = "字典编号不能为空", groups = {create.class, update.class})
    @Length(max = 32, message = "字典编号大于32个字符", groups = {create.class, update.class})
    private String dictCode;

    /**
     * 字典描述
     */
    @Length(max = 256, message = "字典描述大于32个字符", groups = {create.class, update.class})
    private String dictDesc;

    /**
     * 状态：0=停用；1=启用
     */
    @NotNull(message = "状态不能为空", groups = {create.class, update.class})
    private SysDictStatus dictStatus;

}
