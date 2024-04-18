package cc.xuepeng.ray.framework.module.system.domain.vo;

import cc.xuepeng.ray.framework.core.model.vo.BaseVo;
import cc.xuepeng.ray.framework.module.system.domain.enums.SysRoleStatus;
import lombok.*;

/**
 * 系统角色的响应类
 *
 * @author xuepeng
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class SysRoleVo extends BaseVo {

    /**
     * 名称
     */
    private String roleName;

    /**
     * 编号
     */
    private String roleCode;

    /**
     * 状态：0=停用；1=启用
     */
    private SysRoleStatus roleStatus;

    /**
     * 排序
     */
    private Integer roleSort;

    /**
     * 备注
     */
    private String roleRemark;

}
