package cc.xuepeng.ray.framework.module.system.domain.converter;

import cc.xuepeng.ray.framework.core.auth.model.CurrentUserDept;
import cc.xuepeng.ray.framework.core.mybatis.converter.BizConverter;
import cc.xuepeng.ray.framework.module.system.domain.dto.SysDeptDto;
import cc.xuepeng.ray.framework.module.system.domain.entity.SysDept;
import cc.xuepeng.ray.framework.module.system.domain.param.SysDeptParam;
import cc.xuepeng.ray.framework.module.system.domain.vo.SysDeptVo;
import org.mapstruct.Mapper;

/**
 * 系统部门对象转换接口
 *
 * @author xuepeng
 */
@Mapper(componentModel = "spring")
public interface SysDeptConverter extends BizConverter<SysDeptParam, SysDeptDto, SysDept, SysDeptVo> {

    /**
     * Dto转换成CurrentDept
     *
     * @param sysDeptDto 系统部门的数据传输对象
     * @return CurrentDept对象
     */
    CurrentUserDept dtoToCurrentUserDept(SysDeptDto sysDeptDto);

}
