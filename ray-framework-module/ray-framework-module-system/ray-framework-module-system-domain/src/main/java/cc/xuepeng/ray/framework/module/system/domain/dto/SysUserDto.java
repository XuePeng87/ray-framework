package cc.xuepeng.ray.framework.module.system.domain.dto;

import cc.xuepeng.ray.framework.core.model.dto.BaseDto;
import cc.xuepeng.ray.framework.module.system.domain.enums.SysUserStatus;
import lombok.*;

/**
 * 系统用户的数据传输类
 *
 * @author xuepeng
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class SysUserDto extends BaseDto {

    /**
     * 部门编号
     */
    private String deptCode;

    /**
     * 编号
     */
    private String code;

    /**
     * 电话
     */
    private String phoneNumber;

    /**
     * 姓名
     */
    private String name;

    /**
     * 密码
     */
    private String password;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 状态：0=停用；1=启用
     */
    private SysUserStatus status;

    /**
     * 备注
     */
    private String remark;

}
