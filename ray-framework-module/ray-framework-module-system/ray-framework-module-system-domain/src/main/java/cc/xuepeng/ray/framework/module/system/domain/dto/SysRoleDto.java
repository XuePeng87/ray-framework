package cc.xuepeng.ray.framework.module.system.domain.dto;

import cc.xuepeng.ray.framework.core.model.dto.BaseDto;
import cc.xuepeng.ray.framework.module.system.domain.enums.SysRoleStatus;
import lombok.*;

/**
 * 系统角色的数据传输类
 *
 * @author xuepeng
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class SysRoleDto extends BaseDto {

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
