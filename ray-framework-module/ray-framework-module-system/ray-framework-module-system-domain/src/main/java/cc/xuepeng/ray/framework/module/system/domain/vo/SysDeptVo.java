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
     * 父级主键
     */
    private String parentCode;

    /**
     * 编号
     */
    private String code;

    /**
     * 名称
     */
    private String name;

    /**
     * 状态：0=停用；1=启用；
     */
    private SysDeptStatus status;

    /**
     * 排序
     */
    private Integer sequence;

    /**
     * 备注
     */
    private String remark;

    /**
     * 子部门
     */
    private List<SysDeptVo> children = new ArrayList<>();

}
