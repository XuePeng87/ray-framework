package cc.xuepeng.ray.framework.module.system.domain.converter;

import cc.xuepeng.ray.framework.core.auth.model.CurrentUserRole;
import cc.xuepeng.ray.framework.core.mybatis.converter.BizConverter;
import cc.xuepeng.ray.framework.module.system.domain.dto.SysRoleDto;
import cc.xuepeng.ray.framework.module.system.domain.entity.SysRole;
import cc.xuepeng.ray.framework.module.system.domain.param.SysRoleParam;
import cc.xuepeng.ray.framework.module.system.domain.vo.SysRoleVo;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * 系统角色对象转换接口
 *
 * @author xuepeng
 */
@Mapper(componentModel = "spring")
public interface SysRoleConverter extends BizConverter<SysRoleParam, SysRoleDto, SysRole, SysRoleVo> {

    /**
     * Dto集合转换成CurrentUserRole集合
     *
     * @param sysRoleDtoList 系统角色的数据传输对象集合
     * @return CurrentUserRole集合
     */
    List<CurrentUserRole> dtoListToCurrentUserRoleList(final List<SysRoleDto> sysRoleDtoList);


}
