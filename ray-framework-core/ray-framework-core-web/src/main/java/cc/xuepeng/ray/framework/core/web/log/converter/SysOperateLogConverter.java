package cc.xuepeng.ray.framework.core.web.log.converter;

import cc.xuepeng.ray.framework.core.mybatis.converter.BizConverter;
import cc.xuepeng.ray.framework.core.web.log.domain.dto.SysOperateLogDto;
import cc.xuepeng.ray.framework.core.web.log.domain.entity.SysOperateLog;
import cc.xuepeng.ray.framework.core.web.log.domain.param.SysOperateLogParam;
import cc.xuepeng.ray.framework.core.web.log.domain.vo.SysOperateLogVo;
import org.mapstruct.Mapper;

/**
 * 系统操作日志对象转换接口
 *
 * @author xuepeng
 */
@Mapper(componentModel = "spring")
public interface SysOperateLogConverter
        extends BizConverter<SysOperateLogParam, SysOperateLogDto, SysOperateLog, SysOperateLogVo> {

}
