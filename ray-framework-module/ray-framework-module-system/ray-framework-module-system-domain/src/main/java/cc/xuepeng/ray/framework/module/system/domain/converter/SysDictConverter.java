package cc.xuepeng.ray.framework.module.system.domain.converter;

import cc.xuepeng.ray.framework.core.mybatis.converter.BizConverter;
import cc.xuepeng.ray.framework.module.system.domain.dto.SysDictDto;
import cc.xuepeng.ray.framework.module.system.domain.entity.SysDict;
import cc.xuepeng.ray.framework.module.system.domain.param.SysDictParam;
import cc.xuepeng.ray.framework.module.system.domain.vo.SysDictVo;
import org.mapstruct.Mapper;

/**
 * 系统字典对象转换接口
 *
 * @author xuepeng
 */
@Mapper(componentModel = "spring")
public interface SysDictConverter extends BizConverter<SysDictParam, SysDictDto, SysDict, SysDictVo> {
}
