package cc.xuepeng.ray.framework.module.system.domain.param;

import cc.xuepeng.ray.framework.core.model.param.BaseParam;
import cc.xuepeng.ray.framework.core.model.param.ParamValidateScope;
import cc.xuepeng.ray.framework.module.system.domain.enums.SysDictContentStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.validator.constraints.Length;

/**
 * 系统字典项数据请求类
 *
 * @author xuepeng
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class SysDictContentParam extends BaseParam implements ParamValidateScope {

    /**
     * 字典表主键
     */
    @NotNull(message = "字典表主键不能为空", groups = {update.class, create.class})
    private Long pid;

    /**
     * 字典项名称
     */
    @NotBlank(message = "字典项名称不能为空", groups = {update.class, create.class})
    @Length(max = 128, message = "字典项名称大于128个字符", groups = {create.class, update.class})
    private String contentName;

    /**
     * 字典项编号
     */
    @NotBlank(message = "字典项编号不能为空", groups = {update.class, create.class})
    @Length(max = 32, message = "字典项编号大于32个字符", groups = {create.class, update.class})
    private String contentCode;

    /**
     * 排序
     */
    private Long contentSort;

    /**
     * 描述
     */
    @Length(max = 256, message = "字典项描述大于256个字符", groups = {create.class, update.class})
    private String contentRemark;

    /**
     * 状态：0=停用；1=启用
     */
    @NotNull(message = "状态不能为空", groups = {create.class, update.class})
    private SysDictContentStatus contentStatus;

}
