package cc.xuepeng.ray.framework.module.system.domain.vo;

import cc.xuepeng.ray.framework.core.model.vo.BaseVo;
import cc.xuepeng.ray.framework.module.system.domain.enums.SysFuncType;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 系统功能的响应类
 *
 * @author xuepeng
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class SysFuncVo extends BaseVo {

    /**
     * 父级编号
     */
    private Long pid;

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
    private SysFuncType type;

    /**
     * 图标
     */
    private String icon;

    /**
     * 路由地址
     */
    private String path;

    /**
     * 重定向地址
     */
    private String redirect;

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
     * 始终显示根菜单
     */
    private Boolean alwaysShow;

    /**
     * 组件权限
     */
    private String permission;

    /**
     * 组件地址
     */
    private String component;

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
    private List<SysFuncVo> children = new ArrayList<>();

}
