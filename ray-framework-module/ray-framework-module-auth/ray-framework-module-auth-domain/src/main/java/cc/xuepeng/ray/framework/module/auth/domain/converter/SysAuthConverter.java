package cc.xuepeng.ray.framework.module.auth.domain.converter;

import cc.xuepeng.ray.framework.module.auth.domain.dto.SysLoginDto;
import cc.xuepeng.ray.framework.module.auth.domain.param.SysLoginParam;
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
     * @param sysLoginParam Param对象
     * @return Dto对象
     */
    SysLoginDto paramToDto(final SysLoginParam sysLoginParam);

}
