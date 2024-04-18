package cc.xuepeng.ray.framework.module.system.domain.param;

import cc.xuepeng.ray.framework.core.model.param.BaseParam;
import cc.xuepeng.ray.framework.core.model.param.ParamValidateScope;
import cc.xuepeng.ray.framework.module.system.domain.enums.SysDeptStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.validator.constraints.Length;

/**
 * 系统部门的请求类
 *
 * @author xuepeng
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class SysDeptParam extends BaseParam implements ParamValidateScope {

    /**
     * 父主键
     */
    @NotNull(message = "父主键不能为空", groups = {create.class, update.class})
    private Long pid;

    /**
     * 编号
     */
    @Length(max = 32, message = "编号长度不能大于32个字符", groups = {create.class, update.class, page.class})
    private String deptCode;

    /**
     * 名称
     */
    @NotBlank(message = "名称不能为空", groups = {create.class, update.class})
    @Length(max = 32, message = "名称长度不能大于32个字符", groups = {create.class, update.class, page.class})
    private String deptName;

    /**
     * 别名
     */
    @Length(max = 32, message = "别名长度不能大于32个字符", groups = {create.class, update.class, page.class})
    private String deptAlias;

    /**
     * 图标
     */
    @Length(max = 256, message = "图标长度不能大于256个字符", groups = {create.class, update.class, page.class})
    private String deptIcon;

    /**
     * 状态：0=停用；1=启用
     */
    @NotNull(message = "状态不能为空", groups = {create.class, update.class})
    private SysDeptStatus deptStatus;

    /**
     * 排序
     */
    @NotNull(message = "排序不能为空", groups = {create.class, update.class})
    private Integer deptSort;

    /**
     * 备注
     */
    @Length(max = 256, message = "备注长度不能大于256个字符", groups = {create.class, update.class, page.class})
    private String deptRemark;

}
