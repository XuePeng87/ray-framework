package cc.xuepeng.ray.framework.module.system.domain.entity;

import cc.xuepeng.ray.framework.core.mybatis.entity.BizEntity;
import cc.xuepeng.ray.framework.module.system.domain.enums.SysDictContentStatus;
import lombok.*;

/**
 * 系统字典项实体类
 * 数据库表：sys_dict_content，系统字典项表
 *
 * @author xuepeng
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class SysDictContent extends BizEntity {

    /**
     * 字典项表主键
     * 数据库字段：pid，bigint(20)
     */
    private Long pid;

    /**
     * 字典项名称
     * 数据库字段：content_name，varchar(32)
     */
    private String contentName;

    /**
     * 字典项编号
     * 数据库字段：content_code，varchar(32)
     */
    private String contentCode;

    /**
     * 排序
     * 数据库字段：content_sort，int(11)
     */
    private Long contentSort;

    /**
     * 描述
     * 数据库字段：content_remark，varchar(56)
     */
    private String contentRemark;

    /**
     * 状态：0=停用；1=启用
     * 数据库字段：content_status，tinyint(1)
     */
    private SysDictContentStatus contentStatus;
}
