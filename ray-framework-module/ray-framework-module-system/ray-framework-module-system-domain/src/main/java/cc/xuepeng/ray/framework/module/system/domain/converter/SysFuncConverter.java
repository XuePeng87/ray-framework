package cc.xuepeng.ray.framework.module.system.domain.converter;

import cc.xuepeng.ray.framework.core.mybatis.converter.BizConverter;
import cc.xuepeng.ray.framework.module.system.domain.dto.SysFuncDto;
import cc.xuepeng.ray.framework.module.system.domain.entity.SysFunc;
import cc.xuepeng.ray.framework.module.system.domain.param.SysFuncParam;
import cc.xuepeng.ray.framework.module.system.domain.vo.SysFuncVo;
import org.mapstruct.Mapper;

/**
 * 系统功能对象转换接口
 *
 * @author xuepeng
 */
@Mapper(componentModel = "spring")
public interface SysFuncConverter extends BizConverter<SysFuncParam, SysFuncDto, SysFunc, SysFuncVo> {

}
