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
     * 编号
     */
    private String userCode;

    /**
     * 帐号
     */
    private String userAccount;

    /**
     * 姓名
     */
    private String userName;

    /**
     * 密码
     */
    private String userPassword;

    /**
     * 邮箱
     */
    private String userEmail;

    /**
     * 电话
     */
    private String userPhone;

    /**
     * 头像
     */
    private String userAvatar;

    /**
     * 状态：0=停用；1=启用
     */
    private SysUserStatus userStatus;

    /**
     * 备注
     */
    private String userRemark;

}
