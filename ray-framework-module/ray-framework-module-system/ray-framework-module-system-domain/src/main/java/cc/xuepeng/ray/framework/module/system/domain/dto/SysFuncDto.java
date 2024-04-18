package cc.xuepeng.ray.framework.module.system.domain.dto;

import cc.xuepeng.ray.framework.core.common.strategy.composite.Composite;
import cc.xuepeng.ray.framework.core.model.dto.BaseDto;
import cc.xuepeng.ray.framework.module.system.domain.enums.SysFuncType;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 系统功能的数据传输类
 *
 * @author xuepeng
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class SysFuncDto extends BaseDto implements Composite {

    /**
     * 父功能主键
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
     * 子系统功能
     */
    private List<SysFuncDto> children = new ArrayList<>();

    /**
     * @return 获取主键
     */
    @Override
    public String getNodeId() {
        return super.getId().toString();
    }

    /**
     * @return 获取名称
     */
    @Override
    public String getNodeName() {
        return this.funcName;
    }

    /**
     * @return 获取父级主键
     */
    @Override
    public String getNodePid() {
        return this.pid.toString();
    }

    /**
     * 添加到子级
     *
     * @param composite 组合对象
     */
    @Override
    public void add(final Composite composite) {
        this.children.add((SysFuncDto) composite);
    }

    /**
     * 移除子级
     *
     * @param index 组合对象索引
     */
    @Override
    public void remove(final int index) {
        this.children.remove(index);
    }

}
