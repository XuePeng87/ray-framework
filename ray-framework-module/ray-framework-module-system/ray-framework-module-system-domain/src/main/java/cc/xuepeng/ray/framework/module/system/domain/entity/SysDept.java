package cc.xuepeng.ray.framework.module.system.domain.entity;

import cc.xuepeng.ray.framework.core.mybatis.entity.BizEntity;
import cc.xuepeng.ray.framework.module.system.domain.enums.SysDeptStatus;
import lombok.*;

/**
 * 系统部门的实体类
 * 数据库表：sys_dept，系统部门表
 *
 * @author xuepeng
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class SysDept extends BizEntity {

    /**
     * 父级编号
     * 数据库字段：parent_code，char(32)
     */
    private String parentCode;

    /**
     * 编号
     * 数据库字段：code，char(32)
     */
    private String code;

    /**
     * 名称
     * 数据库字段：name，varchar(32)
     */
    private String name;

    /**
     * 排序
     * 数据库字段：sort，int(11)
     */
    private Integer sort;

    /**
     * 状态：0=停用；1=启用
     * 数据库字段：status，tinyint(2)
     */
    private SysDeptStatus status;

    /**
     * 备注
     * 数据库字段：remark，varchar(256)
     */
    private String remark;

}
