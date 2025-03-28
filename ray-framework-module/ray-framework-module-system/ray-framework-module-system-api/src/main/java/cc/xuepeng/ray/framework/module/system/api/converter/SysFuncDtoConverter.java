package cc.xuepeng.ray.framework.module.system.api.converter;

import cc.xuepeng.ray.framework.core.mybatis.converter.DtoConverter;
import cc.xuepeng.ray.framework.module.system.api.request.SysFuncRequest;
import cc.xuepeng.ray.framework.module.system.api.response.SysFuncResponse;
import cc.xuepeng.ray.framework.module.system.service.dto.SysFuncDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * 系统功能数据传输类转换接口
 *
 * @author xuepeng
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SysFuncDtoConverter
        extends DtoConverter<SysFuncRequest, SysFuncDto, SysFuncResponse> {

}
