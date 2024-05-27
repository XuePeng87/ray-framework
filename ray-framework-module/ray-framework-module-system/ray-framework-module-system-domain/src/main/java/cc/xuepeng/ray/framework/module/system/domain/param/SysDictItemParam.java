package cc.xuepeng.ray.framework.module.system.domain.param;

import cc.xuepeng.ray.framework.core.model.param.BaseParam;
import cc.xuepeng.ray.framework.core.model.param.ParamValidateScope;
import cc.xuepeng.ray.framework.module.system.domain.enums.SysDictStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.validator.constraints.Length;

/**
 * 系统字典项的数据请求类
 *
 * @author xuepeng
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class SysDictItemParam extends BaseParam implements ParamValidateScope {

    /**
     * 字典表主键
     */
    @NotBlank(message = "字典编号不能为空", groups = {update.class, create.class})
    private String dictCode;

    /**
     * 字典项名称
     */
    @NotBlank(message = "名称不能为空", groups = {update.class, create.class})
    @Length(max = 16, message = "名称大于16个字符", groups = {create.class, update.class})
    private String name;

    /**
     * 字典值
     */
    @NotBlank(message = "字典值不能为空", groups = {create.class, update.class})
    @Length(max = 16, message = "字典值大于16个字符", groups = {create.class, update.class})
    private String value;

    /**
     * 状态：0=停用；1=启用
     */
    @NotNull(message = "状态不能为空", groups = {create.class, update.class})
    private SysDictStatus status;

    /**
     * 排序
     */
    @NotNull(message = "排序不能为空", groups = {create.class, update.class})
    private Integer sequence;

    /**
     * 描述
     */
    @Length(max = 256, message = "描述大于256个字符", groups = {create.class, update.class})
    private String remark;

}
