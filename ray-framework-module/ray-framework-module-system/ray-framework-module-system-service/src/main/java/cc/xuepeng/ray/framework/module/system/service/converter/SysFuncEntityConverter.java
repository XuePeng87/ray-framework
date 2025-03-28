package cc.xuepeng.ray.framework.module.system.service.converter;

import cc.xuepeng.ray.framework.core.mybatis.converter.EntityConverter;
import cc.xuepeng.ray.framework.module.system.entity.SysFunc;
import cc.xuepeng.ray.framework.module.system.service.dto.SysFuncDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * 系统功能实体类转换接口
 *
 * @author xuepeng
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SysFuncEntityConverter
        extends EntityConverter<SysFuncDto, SysFunc> {

}
