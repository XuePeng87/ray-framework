package cc.xuepeng.ray.framework.module.system.domain.converter;

import cc.xuepeng.ray.framework.core.mybatis.converter.BizConverter;
import cc.xuepeng.ray.framework.module.system.domain.dto.SysUserDto;
import cc.xuepeng.ray.framework.module.system.domain.entity.SysUser;
import cc.xuepeng.ray.framework.module.system.domain.param.SysUserParam;
import cc.xuepeng.ray.framework.module.system.domain.vo.SysUserVo;
import org.mapstruct.Mapper;

/**
 * 系统用户对象转换接口
 *
 * @author xuepeng
 */
@Mapper(componentModel = "spring")
public interface SysUserConverter extends BizConverter<SysUserParam, SysUserDto, SysUser, SysUserVo> {

}
