package cc.xuepeng.ray.framework.module.system.service.converter;

import cc.xuepeng.ray.framework.core.mybatis.converter.EntityConverter;
import cc.xuepeng.ray.framework.module.system.entity.SysDept;
import cc.xuepeng.ray.framework.module.system.service.dto.SysDeptDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * 系统部门实体类转换接口
 *
 * @author xuepeng
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SysDeptEntityConverter
        extends EntityConverter<SysDeptDto, SysDept> {
}
