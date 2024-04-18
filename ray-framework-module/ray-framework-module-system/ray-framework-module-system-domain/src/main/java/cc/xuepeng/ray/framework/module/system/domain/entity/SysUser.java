package cc.xuepeng.ray.framework.module.system.domain.entity;

import cc.xuepeng.ray.framework.core.mybatis.entity.BizEntity;
import cc.xuepeng.ray.framework.module.system.domain.enums.SysUserStatus;
import lombok.*;

/**
 * 系统用户的实体类
 * 数据库表：sys_user，系统用户表
 *
 * @author xuepeng
 */
@Data
@ToString
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class SysUser extends BizEntity {

    /**
     * 部门编号
     * 数据库字段：dept_id，char(32)
     */
    private String deptCode;

    /**
     * 编号
     * 数据库字段：user_code，char(32)
     */
    private String userCode;

    /**
     * 帐号
     * 数据库字段：user_account，varchar(32)
     */
    private String userAccount;

    /**
     * 姓名
     * 数据库字段：user_name，varchar(32)
     */
    private String userName;

    /**
     * 密码
     * 数据库字段：user_password，varchar(128)
     */
    private String userPassword;

    /**
     * 邮箱
     * 数据库字段：user_email，varchar(128)
     */
    private String userEmail;

    /**
     * 电话
     * 数据库字段：user_phone，varchar(32)
     */
    private String userPhone;

    /**
     * 头像
     * 数据库字段：user_avatar，varchar(256)
     */
    private String userAvatar;

    /**
     * 状态：0=停用；1=启用
     * 数据库字段：user_status，tinyint(2)
     */
    private SysUserStatus userStatus;

    /**
     * 备注
     * 数据库字段：user_remark，varchar(256)
     */
    private String userRemark;

}
