package cc.xuepeng.ray.framework.module.common.log.converter;

import cc.xuepeng.ray.framework.core.mybatis.converter.EntityConverter;
import cc.xuepeng.ray.framework.module.common.log.domain.dto.SysAuthLogDto;
import cc.xuepeng.ray.framework.module.common.log.domain.entity.SysAuthLog;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * 系统登录登出日志实体类转换接口
 *
 * @author xuepeng
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SysAuthLogEntityConverter
        extends EntityConverter<SysAuthLogDto, SysAuthLog> {

}
