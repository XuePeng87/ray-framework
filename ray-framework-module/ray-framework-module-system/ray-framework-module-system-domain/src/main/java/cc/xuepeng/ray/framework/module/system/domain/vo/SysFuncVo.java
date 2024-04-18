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
     * 父主键
     */
    private Long pid;

    /**
     * 名称
     */
    private String funcName;

    /**
     * 编号
     */
    private String funcCode;

    /**
     * 类型：0=目录，1=菜单；2=按钮
     */
    private SysFuncType funcType;

    /**
     * 图标
     */
    private String funcIcon;

    /**
     * 路由地址
     */
    private String funcPath;

    /**
     * 是否外链
     */
    private Boolean funcLinkable;

    /**
     * 是否缓存
     */
    private Boolean funcCacheable;

    /**
     * 是否可见
     */
    private Boolean funcVisible;

    /**
     * 组件名称
     */
    private String funcComponentName;

    /**
     * 组件地址
     */
    private String funcComponentPath;

    /**
     * 排序
     */
    private Integer funcSort;

    /**
     * 备注
     */
    private String funcRemark;

    /**
     * 是否内置
     */
    private Boolean fixed;

    /**
     * 子功能
     */
    private List<SysFuncVo> children = new ArrayList<>();

}
