package cc.xuepeng.ray.framework.core.web.log.converter;

import cc.xuepeng.ray.framework.core.mybatis.converter.BizConverter;
import cc.xuepeng.ray.framework.core.web.log.domain.dto.SysOperateLogDetailDto;
import cc.xuepeng.ray.framework.core.web.log.domain.entity.SysOperateLogDetail;
import cc.xuepeng.ray.framework.core.web.log.domain.param.SysOperateLogDetailParam;
import org.mapstruct.Mapper;

/**
 * 系统操作日志详情对象转换接口
 *
 * @author xuepeng
 */
@Mapper(componentModel = "spring")
public interface SysOperateLogDetailConverter
        extends BizConverter<SysOperateLogDetailParam, SysOperateLogDetailDto, SysOperateLogDetail, SysOperateLogDetailDto> {

}
