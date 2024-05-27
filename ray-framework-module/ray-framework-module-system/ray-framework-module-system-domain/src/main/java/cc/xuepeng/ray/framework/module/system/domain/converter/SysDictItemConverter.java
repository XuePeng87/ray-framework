package cc.xuepeng.ray.framework.module.system.domain.converter;

import cc.xuepeng.ray.framework.core.mybatis.converter.BizConverter;
import cc.xuepeng.ray.framework.module.system.domain.dto.SysDictItemDto;
import cc.xuepeng.ray.framework.module.system.domain.entity.SysDictItem;
import cc.xuepeng.ray.framework.module.system.domain.param.SysDictItemParam;
import cc.xuepeng.ray.framework.module.system.domain.vo.SysDictItemVo;
import org.mapstruct.Mapper;

/**
 * 系统字典项对象转换接口
 *
 * @author xuepeng
 */
@Mapper(componentModel = "spring")
public interface SysDictItemConverter extends BizConverter<SysDictItemParam, SysDictItemDto, SysDictItem, SysDictItemVo> {

}
