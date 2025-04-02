package cc.xuepeng.ray.framework.module.common.log.converter;

import cc.xuepeng.ray.framework.core.mybatis.converter.DtoConverter;
import cc.xuepeng.ray.framework.module.common.log.domain.dto.SysOperateLogDto;
import cc.xuepeng.ray.framework.module.common.log.domain.request.SysOperateLogRequest;
import cc.xuepeng.ray.framework.module.common.log.domain.response.SysOperateLogResponse;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * 系统操作日志数据传输类转换接口
 *
 * @author xuepeng
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SysOperateLogDtoConverter
        extends DtoConverter<SysOperateLogRequest, SysOperateLogDto, SysOperateLogResponse> {
}