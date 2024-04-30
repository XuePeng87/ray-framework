package cc.xuepeng.ray.framework.core.auth.model;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 当前用户部门的实体类
 *
 * @author xuepeng
 */
@Data
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class CurrentUserFunc {

    /**
     * 父级主键
     */
    private String parentCode;

    /**
     * 名称
     */
    private String name;

    /**
     * 编号
     */
    private String code;

    /**
     * 类型：0=目录，1=功能；2=按钮
     */
    private Integer type;

    /**
     * 图标
     */
    private String icon;

    /**
     * 路由地址
     */
    private String path;

    /**
     * 是否外链
     */
    private Boolean linkable;

    /**
     * 是否缓存
     */
    private Boolean cacheable;

    /**
     * 是否可见
     */
    private Boolean visible;

    /**
     * 组件名称
     */
    private String componentName;

    /**
     * 组件地址
     */
    private String componentPath;

    /**
     * 排序
     */
    private Integer sequence;

    /**
     * 备注
     */
    private String remark;

    /**
     * 子功能
     */
    private List<CurrentUserFunc> children = new ArrayList<>();

}
