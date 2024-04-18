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
     * 父级部门主键
     * 数据库字段：pid，bigint(20)
     */
    private Long pid;

    /**
     * 编号
     * 数据库字段：dept_code，char(32)
     */
    private String deptCode;

    /**
     * 名称
     * 数据库字段：dept_name，varchar(32)
     */
    private String deptName;

    /**
     * 别名
     * 数据库字段：dept_alias，varchar(32)
     */
    private String deptAlias;

    /**
     * 图标
     * 数据库字段：dept_icon，varchar(256)
     */
    private String deptIcon;

    /**
     * 排序
     * 数据库字段：dept_sort，int(11)
     */
    private Integer deptSort;

    /**
     * 状态：0=停用；1=启用
     * 数据库字段：dept_status，tinyint(2)
     */
    private SysDeptStatus deptStatus;

    /**
     * 备注
     * 数据库字段：dept_remark，varchar(256)
     */
    private String deptRemark;

}
