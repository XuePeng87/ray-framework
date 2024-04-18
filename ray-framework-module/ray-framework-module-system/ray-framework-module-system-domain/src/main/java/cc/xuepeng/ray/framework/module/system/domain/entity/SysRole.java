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
     * 数据库字段：name，varchar(32)
     */
    private String name;

    /**
     * 编号
     * 数据库字段：code，varchar(32)
     */
    private String code;

    /**
     * 状态：0=停用；1=启用
     * 数据库字段：status，tinyint(2)
     */
    private SysRoleStatus status;

    /**
     * 排序
     * 数据库字段：sort，int(11)
     */
    private Integer sort;

    /**
     * 备注
     * 数据库字段：remark，varchar(256)
     */
    private String remark;

}
