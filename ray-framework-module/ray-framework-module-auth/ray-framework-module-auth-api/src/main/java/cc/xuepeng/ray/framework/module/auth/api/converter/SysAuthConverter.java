package cc.xuepeng.ray.framework.module.auth.api.converter;

import cc.xuepeng.ray.framework.module.auth.api.request.SysLoginRequest;
import cc.xuepeng.ray.framework.module.auth.service.dto.SysLoginDto;
import org.mapstruct.Mapper;

/**
 * 系统认证对象转换接口
 *
 * @author xuepeng
 */
@Mapper(componentModel = "spring")
public interface SysAuthConverter {

    /**
     * Param转换Dto
     *
     * @param sysLoginRequest Param对象
     * @return Dto对象
     */
    SysLoginDto requestToDto(final SysLoginRequest sysLoginRequest);

}
