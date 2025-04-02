package cc.xuepeng.ray.framework.module.common.log.converter;

import cc.xuepeng.ray.framework.core.mybatis.converter.DtoConverter;
import cc.xuepeng.ray.framework.module.common.log.domain.dto.SysAuthLogDto;
import cc.xuepeng.ray.framework.module.common.log.domain.request.SysAuthLogRequest;
import cc.xuepeng.ray.framework.module.common.log.domain.response.SysAuthLogResponse;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * 系统登录登出日志数据传输类转换接口
 *
 * @author xuepeng
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SysAuthLogDtoConverter
        extends DtoConverter<SysAuthLogRequest, SysAuthLogDto, SysAuthLogResponse> {
}
