package cc.xuepeng.ray.framework.module.system.api.converter;

import cc.xuepeng.ray.framework.core.mybatis.converter.DtoConverter;
import cc.xuepeng.ray.framework.module.system.api.request.SysUserRequest;
import cc.xuepeng.ray.framework.module.system.api.response.SysUserResponse;
import cc.xuepeng.ray.framework.module.system.service.dto.SysUserDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * 系统用户数据传输类转换接口
 *
 * @author xuepeng
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SysUserDtoConverter
        extends DtoConverter<SysUserRequest, SysUserDto, SysUserResponse> {

}
