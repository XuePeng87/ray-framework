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
     * 数据库字段：dept_code，char(32)
     */
    private String deptCode;

    /**
     * 编号
     * 数据库字段：code，char(32)
     */
    private String code;

    /**
     * 帐号
     * 数据库字段：account，varchar(32)
     */
    private String account;

    /**
     * 姓名
     * 数据库字段：name，varchar(32)
     */
    private String name;

    /**
     * 密码
     * 数据库字段：password，varchar(128)
     */
    private String password;

    /**
     * 邮箱
     * 数据库字段：email，varchar(128)
     */
    private String email;

    /**
     * 电话
     * 数据库字段：phone_number，varchar(32)
     */
    private String phoneNumber;

    /**
     * 头像
     * 数据库字段：avatar，varchar(256)
     */
    private String avatar;

    /**
     * 状态：0=停用；1=启用
     * 数据库字段：status，tinyint(2)
     */
    private SysUserStatus status;

    /**
     * 备注
     * 数据库字段：remark，varchar(256)
     */
    private String remark;

}
