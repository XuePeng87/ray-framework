package cc.xuepeng.ray.framework.module.system.domain.converter;

import cc.xuepeng.ray.framework.core.auth.model.CurrentUserFunc;
import cc.xuepeng.ray.framework.core.mybatis.converter.BizConverter;
import cc.xuepeng.ray.framework.module.system.domain.dto.SysFuncDto;
import cc.xuepeng.ray.framework.module.system.domain.entity.SysFunc;
import cc.xuepeng.ray.framework.module.system.domain.param.SysFuncParam;
import cc.xuepeng.ray.framework.module.system.domain.vo.SysFuncVo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

/**
 * 系统功能对象转换接口
 *
 * @author xuepeng
 */
@Mapper(componentModel = "spring")
public interface SysFuncConverter extends BizConverter<SysFuncParam, SysFuncDto, SysFunc, SysFuncVo> {

    @Mapping(source = "type.code", target = "type")
    CurrentUserFunc dtoToCurrentUserFunc(final SysFuncDto sysFuncDto);

    List<CurrentUserFunc> dtoListToCurrentUserFuncList(final List<SysFuncDto> sysFuncDtoList);

}
