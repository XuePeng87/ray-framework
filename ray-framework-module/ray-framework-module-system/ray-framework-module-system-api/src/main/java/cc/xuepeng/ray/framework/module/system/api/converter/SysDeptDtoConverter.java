package cc.xuepeng.ray.framework.module.system.api.converter;

import cc.xuepeng.ray.framework.core.mybatis.converter.DtoConverter;
import cc.xuepeng.ray.framework.module.system.api.request.SysDeptRequest;
import cc.xuepeng.ray.framework.module.system.api.response.SysDeptResponse;
import cc.xuepeng.ray.framework.module.system.service.dto.SysDeptDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * 系统部门数据传输类转换接口
 *
 * @author xuepeng
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SysDeptDtoConverter
        extends DtoConverter<SysDeptRequest, SysDeptDto, SysDeptResponse> {

}
