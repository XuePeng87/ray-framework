package cc.xuepeng.ray.framework.module.system.domain.entity;

import cc.xuepeng.ray.framework.core.mybatis.entity.BizEntity;
import cc.xuepeng.ray.framework.module.system.domain.enums.SysFuncType;
import lombok.*;

/**
 * 系统功能的实体类
 * 数据库表：sys_func，系统功能表
 *
 * @author xuepeng
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class SysFunc extends BizEntity {

    /**
     * 父级编号
     * 数据库字段：parent_code，char(32)
     */
    private String parentCode;

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
     * 类型：0=目录，1=功能；2=按钮
     * 数据库字段：type，tinyint(2)
     */
    private SysFuncType type;

    /**
     * 图标
     * 数据库字段：icon，varchar(32)
     */
    private String icon;

    /**
     * 路由地址
     * 数据库字段：path，varchar(256)
     */
    private String path;

    /**
     * 是否外链
     * 数据库字段：linkable，tinyint(1)
     */
    private Boolean linkable;

    /**
     * 是否缓存
     * 数据库字段：cacheable，tinyint(1)
     */
    private Boolean cacheable;

    /**
     * 是否可见
     * 数据库字段：visible，tinyint(1)
     */
    private Boolean visible;

    /**
     * 组件名称
     * 数据库字段：component_name，varchar(32)
     */
    private String componentName;

    /**
     * 组件地址
     * 数据库字段：component_path，varchar(256)
     */
    private String componentPath;

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
