package cc.xuepeng.ray.framework.module.system.domain.converter;

import cc.xuepeng.ray.framework.core.mybatis.converter.BizConverter;
import cc.xuepeng.ray.framework.module.system.domain.dto.SysDictContentDto;
import cc.xuepeng.ray.framework.module.system.domain.entity.SysDictContent;
import cc.xuepeng.ray.framework.module.system.domain.param.SysDictContentParam;
import cc.xuepeng.ray.framework.module.system.domain.vo.SysDictContentVo;
import org.mapstruct.Mapper;

/**
 * 系统字典项项对象转换接口
 *
 * @author xuepeng
 */
@Mapper(componentModel = "spring")
public interface SysDictContentConverter extends BizConverter<SysDictContentParam, SysDictContentDto, SysDictContent, SysDictContentVo> {

}
