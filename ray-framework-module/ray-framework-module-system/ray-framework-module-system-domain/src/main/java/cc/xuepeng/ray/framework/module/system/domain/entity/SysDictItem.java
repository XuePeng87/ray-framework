package cc.xuepeng.ray.framework.module.system.domain.entity;

import cc.xuepeng.ray.framework.core.mybatis.entity.BizEntity;
import lombok.*;

/**
 * 系统字典项的实体类
 * 数据库表：sys_dict_item，系统字典项表
 *
 * @author xuepeng
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class SysDictItem extends BizEntity {

    /**
     * 字典编号
     * 数据库字段：pid，char(32)
     */
    private Long parentCode;

    /**
     * 编号
     * 数据库字段：code，varchar(32)
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
    private Long sort;

    /**
     * 描述
     * 数据库字段：remark，varchar(256)
     */
    private String remark;

}
