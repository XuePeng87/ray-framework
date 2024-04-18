package cc.xuepeng.ray.framework.module.system.domain.vo;

import cc.xuepeng.ray.framework.core.model.vo.BaseVo;
import cc.xuepeng.ray.framework.module.system.domain.enums.SysUserStatus;
import lombok.*;

/**
 * 系统用户的响应类
 *
 * @author xuepeng
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class SysUserVo extends BaseVo {

    /**
     * 租户编号
     */
    private String tenantCode;

    /**
     * 租户名称
     */
    private String tenantName;

    /**
     * 部门编号
     */
    private String deptCode;

    /**
     * 部门名称
     */
    private String deptName;

    /**
     * 编号
     */
    private String userCode;

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
