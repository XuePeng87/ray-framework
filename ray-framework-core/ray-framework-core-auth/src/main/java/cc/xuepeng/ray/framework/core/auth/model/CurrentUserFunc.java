package cc.xuepeng.ray.framework.core.auth.model;

import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 当前登录人功能的实体类
 *
 * @author xuepeng
 */
@Data
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class CurrentUserFunc implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private Long id;

    /**
     * 父级主键
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
     * 类型：0=目录，1=菜单；2=按钮；
     */
    private Integer funcType;

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
     * 子系统功能
     */
    private List<CurrentUserFunc> children = new ArrayList<>();

}
