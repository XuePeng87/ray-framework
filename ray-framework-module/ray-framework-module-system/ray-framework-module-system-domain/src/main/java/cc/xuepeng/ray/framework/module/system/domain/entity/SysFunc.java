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
     * 父功能主键
     * 数据库字段：pid，bigint(20)
     */
    private Long pid;

    /**
     * 编号
     * 数据库字段：func_code，varchar(32)
     */
    private String funcCode;

    /**
     * 名称
     * 数据库字段：func_name，varchar(32)
     */
    private String funcName;

    /**
     * 类型：0=目录，1=菜单；2=按钮
     * 数据库字段：func_type，tinyint(2)
     */
    private SysFuncType funcType;

    /**
     * 图标
     * 数据库字段：func_icon，varchar(32)
     */
    private String funcIcon;

    /**
     * 路由地址
     * 数据库字段：func_path，varchar(256)
     */
    private String funcPath;

    /**
     * 是否外链
     * 数据库字段：func_linkable，tinyint(1)
     */
    private Boolean funcLinkable;

    /**
     * 是否缓存
     * 数据库字段：func_cacheable，tinyint(1)
     */
    private Boolean funcCacheable;

    /**
     * 是否可见
     * 数据库字段：func_visible，tinyint(1)
     */
    private Boolean funcVisible;

    /**
     * 组件名称
     * 数据库字段：func_component_name，varchar(32)
     */
    private String funcComponentName;

    /**
     * 组件地址
     * 数据库字段：func_component_path，varchar(256)
     */
    private String funcComponentPath;

    /**
     * 排序
     * 数据库字段：func_sort，int(11)
     */
    private Integer funcSort;

    /**
     * 备注
     * 数据库字段：func_remark，varchar(256)
     */
    private String funcRemark;

    /**
     * 是否内置
     * 数据库字段：fixed，tinyint(1)
     */
    private Boolean fixed;

}
