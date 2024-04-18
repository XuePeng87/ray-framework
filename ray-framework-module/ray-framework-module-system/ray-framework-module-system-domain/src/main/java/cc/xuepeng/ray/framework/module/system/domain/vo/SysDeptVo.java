package cc.xuepeng.ray.framework.module.system.domain.vo;

import cc.xuepeng.ray.framework.core.model.vo.BaseVo;
import cc.xuepeng.ray.framework.module.system.domain.enums.SysDeptStatus;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 系统部门的响应类
 *
 * @author xuepeng
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class SysDeptVo extends BaseVo {

    /**
     * 父级部门主键
     */
    private Long pid;

    /**
     * 名称
     */
    private String deptName;

    /**
     * 别名
     */
    private String deptAlias;

    /**
     * 编号
     */
    private String deptCode;

    /**
     * 图标
     */
    private String deptIcon;

    /**
     * 状态：0=停用；1=启用；
     */
    private SysDeptStatus deptStatus;

    /**
     * 排序
     */
    private Integer deptSort;

    /**
     * 备注
     */
    private String deptRemark;

    /**
     * 用户数
     */
    private long userCount = 0;

    /**
     * 子机构
     */
    private List<SysDeptVo> children = new ArrayList<>();

}
