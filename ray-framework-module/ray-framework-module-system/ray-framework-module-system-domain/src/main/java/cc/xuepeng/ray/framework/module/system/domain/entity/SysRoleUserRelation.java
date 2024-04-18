package cc.xuepeng.ray.framework.module.system.domain.entity;

import cc.xuepeng.ray.framework.core.mybatis.entity.BaseEntity;
import lombok.*;

/**
 * 系统角色与系统用户关系的实体类
 * 数据库表：sys_role_user_relation，系统角色与系统用户的关系表
 *
 * @author xuepeng
 */
@Data
@ToString
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class SysRoleUserRelation extends BaseEntity {

    /**
     * 角色主键
     * 数据库字段：role_id，bigint(20)
     */
    private Long roleId;

    /**
     * 用户编号
     * 数据库字段：user_code，char(32)
     */
    private String userCode;

}
