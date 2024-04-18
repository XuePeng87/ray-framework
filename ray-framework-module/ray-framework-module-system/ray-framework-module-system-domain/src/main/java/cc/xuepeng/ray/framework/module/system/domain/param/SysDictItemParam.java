package cc.xuepeng.ray.framework.module.system.domain.param;

import cc.xuepeng.ray.framework.core.model.param.BaseParam;
import cc.xuepeng.ray.framework.core.model.param.ParamValidateScope;
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
    @Length(max = 32, message = "字典编号长度不能大于32个字符", groups = {create.class, update.class, page.class})
    private String parentCode;

    /**
     * 字典项编号
     */
    @NotBlank(message = "编号不能为空", groups = {update.class, create.class})
    @Length(max = 32, message = "编号大于32个字符", groups = {create.class, update.class})
    private String code;

    /**
     * 字典项名称
     */
    @NotBlank(message = "名称不能为空", groups = {update.class, create.class})
    @Length(max = 32, message = "名称大于32个字符", groups = {create.class, update.class})
    private String name;

    /**
     * 排序
     */
    @NotNull(message = "排序不能为空", groups = {create.class, update.class})
    private Long sort;

    /**
     * 描述
     */
    @Length(max = 256, message = "描述大于256个字符", groups = {create.class, update.class})
    private String remark;

}
