package cc.xuepeng.ray.framework.module.system.domain.param;

import cc.xuepeng.ray.framework.core.model.param.BaseParam;
import cc.xuepeng.ray.framework.core.model.param.ParamValidateScope;
import cc.xuepeng.ray.framework.module.system.domain.enums.SysFuncType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.validator.constraints.Length;

/**
 * 系统功能的请求类
 *
 * @author xuepeng
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class SysFuncParam extends BaseParam implements ParamValidateScope {

    /**
     * 父级编号
     */
    @NotBlank(message = "父级编号不能为空", groups = {create.class, update.class})
    private String parentCode;

    /**
     * 名称
     */
    @NotBlank(message = "名称不能为空", groups = {create.class, update.class})
    @Length(max = 32, message = "名称长度不能大于32个字符", groups = {create.class, update.class, page.class})
    private String name;

    /**
     * 编号
     */
    @NotBlank(message = "编号不能为空", groups = {create.class, update.class})
    @Length(max = 32, message = "编号长度不能大于32个字符", groups = {create.class, update.class, page.class})
    private String code;

    /**
     * 类型：0=目录，1=功能；2=按钮
     */
    @NotNull(message = "类型不能为空", groups = {create.class, update.class})
    private SysFuncType type;

    /**
     * 图标
     */
    @Length(max = 32, message = "图标长度不能大于32个字符", groups = {create.class, update.class, page.class})
    private String icon;

    /**
     * 路由地址
     */
    @Length(max = 256, message = "路由地址长度不能大于256个字符", groups = {create.class, update.class, page.class})
    private String path;

    /**
     * 是否外链
     */
    @NotNull(message = "是否外链不能为空", groups = {create.class, update.class})
    private Boolean linkable;

    /**
     * 是否缓存
     */
    @NotNull(message = "是否缓存不能为空", groups = {create.class, update.class})
    private Boolean cacheable;

    /**
     * 是否可见
     */
    @NotNull(message = "是否可见不能为空", groups = {create.class, update.class})
    private Boolean visible;

    /**
     * 组件名称
     */
    @Length(max = 32, message = "组件名称长度不能大于32个字符", groups = {create.class, update.class, page.class})
    private String componentName;

    /**
     * 组件地址
     */
    @Length(max = 128, message = "组件地址长度不能大于128个字符")
    private String componentPath;

    /**
     * 排序
     */
    @NotNull(message = "排序不能为空", groups = {create.class, update.class})
    private Integer sort;

    /**
     * 备注
     */
    @Length(max = 256, message = "备注地址长度不能大于256个字符")
    private String remark;

}
