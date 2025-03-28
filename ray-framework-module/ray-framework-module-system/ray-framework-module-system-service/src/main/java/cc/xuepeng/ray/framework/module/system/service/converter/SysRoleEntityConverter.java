package cc.xuepeng.ray.framework.module.system.service.converter;

import cc.xuepeng.ray.framework.core.mybatis.converter.EntityConverter;
import cc.xuepeng.ray.framework.module.system.entity.SysRole;
import cc.xuepeng.ray.framework.module.system.service.dto.SysRoleDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * 系统角色实体类转换接口
 *
 * @author xuepeng
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SysRoleEntityConverter
        extends EntityConverter<SysRoleDto, SysRole> {

}
