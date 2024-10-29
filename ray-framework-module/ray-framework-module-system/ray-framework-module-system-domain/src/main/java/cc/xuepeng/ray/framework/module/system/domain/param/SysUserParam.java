package cc.xuepeng.ray.framework.module.system.domain.param;

import cc.xuepeng.ray.framework.core.model.param.BaseParam;
import cc.xuepeng.ray.framework.core.model.param.ParamValidateScope;
import cc.xuepeng.ray.framework.module.system.domain.enums.SysUserStatus;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.validator.constraints.Length;

/**
 * 系统用户的请求类
 *
 * @author xuepeng
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class SysUserParam extends BaseParam implements ParamValidateScope {

    /**
     * 部门编号
     */
    @NotBlank(message = "部门编号不能为空", groups = {create.class, update.class})
    @Length(max = 32, message = "部门编号长度不能大于32个字符", groups = {create.class, update.class, page.class})
    private String deptCode;

    /**
     * 电话
     */
    @NotBlank(message = "手机号不能为空", groups = {create.class, update.class})
    @Length(max = 32, message = "手机号长度不能大于32个字符", groups = {create.class, update.class, page.class})
    private String phoneNumber;

    /**
     * 姓名
     */
    @NotBlank(message = "姓名不能为空", groups = {create.class, update.class})
    @Length(max = 32, message = "姓名长度不能大于32个字符", groups = {create.class, update.class, page.class})
    private String name;

    /**
     * 邮箱
     */
    @NotBlank(message = "邮箱不能为空", groups = {create.class, update.class})
    @Length(max = 128, message = "邮箱长度不能大于128个字符", groups = {create.class, update.class, page.class})
    @Email(message = "邮箱格式不正确", groups = {create.class, update.class, page.class})
    private String email;

    /**
     * 状态：0=停用；1=启用
     */
    @NotNull(message = "状态不能为空", groups = {create.class, update.class})
    private SysUserStatus status;

    /**
     * 备注
     */
    @Length(max = 256, message = "备注长度不能大于256个字符", groups = {create.class, update.class, page.class})
    private String remark;

}
