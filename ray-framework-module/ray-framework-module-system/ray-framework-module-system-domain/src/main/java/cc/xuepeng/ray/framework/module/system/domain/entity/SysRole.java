package cc.xuepeng.ray.framework.module.system.domain.entity;

import cc.xuepeng.ray.framework.core.mybatis.entity.BizEntity;
import cc.xuepeng.ray.framework.module.system.domain.enums.SysRoleStatus;
import lombok.*;

/**
 * 系统角色的实体类
 * 数据库表：sys_role，系统角色表
 *
 * @author xuepeng
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class SysRole extends BizEntity {

    /**
     * 名称
     * 数据库字段：role_name，varchar(32)
     */
    private String roleName;

    /**
     * 编号
     * 数据库字段：role_code，varchar(32)
     */
    private String roleCode;

    /**
     * 状态：0=停用；1=启用
     * 数据库字段：role_status，tinyint(2)
     */
    private SysRoleStatus roleStatus;

    /**
     * 排序
     * 数据库字段：role_sort，int(11)
     */
    private Integer roleSort;

    /**
     * 备注
     * 数据库字段：role_remark，varchar(256)
     */
    private String roleRemark;

}
