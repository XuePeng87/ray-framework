package cc.xuepeng.ray.framework.core.web.log.converter;

import cc.xuepeng.ray.framework.core.mybatis.converter.BizConverter;
import cc.xuepeng.ray.framework.core.web.log.domain.dto.SysAuthLogDto;
import cc.xuepeng.ray.framework.core.web.log.domain.entity.SysAuthLog;
import cc.xuepeng.ray.framework.core.web.log.domain.param.SysAuthLogParam;
import cc.xuepeng.ray.framework.core.web.log.domain.vo.SysAuthLogVo;
import org.mapstruct.Mapper;

/**
 * 系统登录登出日志对象转换接口
 *
 * @author xuepeng
 */
@Mapper(componentModel = "spring")
public interface SysAuthLogConverter extends BizConverter<SysAuthLogParam, SysAuthLogDto, SysAuthLog, SysAuthLogVo> {

}
