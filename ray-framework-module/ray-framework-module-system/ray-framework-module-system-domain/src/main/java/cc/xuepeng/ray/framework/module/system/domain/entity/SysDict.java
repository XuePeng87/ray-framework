package cc.xuepeng.ray.framework.module.system.domain.entity;

import cc.xuepeng.ray.framework.core.mybatis.entity.BizEntity;
import cc.xuepeng.ray.framework.module.system.domain.enums.SysDictStatus;
import lombok.*;

/**
 * 系统字典实体类
 * 数据库表：sys_dict，系统字典表
 *
 * @author xuepeng
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class SysDict extends BizEntity {

    /**
     * 字典名称
     * 数据库字段：dict_name，varchar(128)
     */
    private String dictName;

    /**
     * 字段编号
     * 数据库字段：dict_code，varchar(32)
     */
    private String dictCode;

    /**
     * 字典描述
     * 数据库字段：dict_desc，varchar(256)
     */
    private String dictDesc;

    /**
     * 状态：0=停用；1=启用
     * 数据库字段：dict_status，tinyint(1)
     */
    private SysDictStatus dictStatus;

}
