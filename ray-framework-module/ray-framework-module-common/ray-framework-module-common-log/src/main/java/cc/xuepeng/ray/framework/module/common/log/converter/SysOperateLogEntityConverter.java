package cc.xuepeng.ray.framework.module.common.log.converter;

import cc.xuepeng.ray.framework.core.mybatis.converter.EntityConverter;
import cc.xuepeng.ray.framework.module.common.log.domain.dto.SysOperateLogDto;
import cc.xuepeng.ray.framework.module.common.log.domain.entity.SysOperateLog;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * 系统操作日志实体类转换接口
 *
 * @author xuepeng
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SysOperateLogEntityConverter
        extends EntityConverter<SysOperateLogDto, SysOperateLog> {

}
