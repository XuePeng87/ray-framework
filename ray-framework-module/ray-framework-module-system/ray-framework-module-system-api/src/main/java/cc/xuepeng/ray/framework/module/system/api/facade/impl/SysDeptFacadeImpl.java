package cc.xuepeng.ray.framework.module.system.api.facade.impl;

import cc.xuepeng.ray.framework.module.system.api.facade.SysDeptFacade;
import cc.xuepeng.ray.framework.module.system.domain.converter.SysDeptConverter;
import cc.xuepeng.ray.framework.module.system.domain.dto.SysDeptDto;
import cc.xuepeng.ray.framework.module.system.domain.param.SysDeptParam;
import cc.xuepeng.ray.framework.module.system.domain.vo.SysDeptVo;
import cc.xuepeng.ray.framework.module.system.service.SysDeptService;
import cc.xuepeng.ray.framework.module.system.service.decorator.SysDeptFormat;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 系统部门的门面实现类
 *
 * @author xuepeng
 */
@Component
public class SysDeptFacadeImpl implements SysDeptFacade {

    /**
     * 创建系统部门
     *
     * @param sysDeptParam 系统部门的请求对象
     * @return 是否创建成功
     */
    @Override
    public boolean create(final SysDeptParam sysDeptParam) {
        final SysDeptDto sysDeptDto = sysDeptConverter.paramToDto(sysDeptParam);
        return sysDeptService.create(sysDeptDto);
    }

    /**
     * 修改系统部门
     *
     * @param code         系统部门的编号
     * @param sysDeptParam 系统部门的请求对象
     * @return 是否修改成功
     */
    @Override
    public boolean update(final String code, final SysDeptParam sysDeptParam) {
        final SysDeptDto sysDeptDto = sysDeptConverter.paramToDto(sysDeptParam);
        sysDeptDto.setCode(code);
        return sysDeptService.update(sysDeptDto);
    }

    /**
     * 删除系统部门
     *
     * @param code 系统部门的编号
     * @return 是否删除成功
     */
    @Override
    public boolean delete(final String code) {
        return sysDeptService.delete(code);
    }

    /**
     * 根据编号查询系统部门
     *
     * @param code 系统部门的编号
     * @return 系统部门的响应对象
     */
    @Override
    public SysDeptVo findByCode(final String code) {
        final SysDeptDto sysDeptDto = sysDeptService.findByCode(code);
        return sysDeptConverter.dtoToVo(sysDeptDto);
    }

    /**
     * 根据条件查询系统部门
     *
     * @param sysDeptParam 系统部门的请求对象
     * @return 系统部门的响应对象集合
     */
    @Override
    public List<SysDeptVo> treeByCondition(final SysDeptParam sysDeptParam) {
        final SysDeptDto sysDeptDto = sysDeptConverter.paramToDto(sysDeptParam);
        final List<SysDeptDto> sysDeptDtos = sysDeptService.listByCondition(sysDeptDto);
        return sysDeptConverter.dtoListToVoList(sysDeptFormat.tree(sysDeptDtos));
    }

    /**
     * 系统部门对象转换接口
     */
    @Resource
    private SysDeptConverter sysDeptConverter;

    /**
     * 系统部门的业务处理接口
     */
    @Resource
    private SysDeptService sysDeptService;

    /**
     * 系统部门格式化接口
     */
    @Resource
    private SysDeptFormat sysDeptFormat;

}
