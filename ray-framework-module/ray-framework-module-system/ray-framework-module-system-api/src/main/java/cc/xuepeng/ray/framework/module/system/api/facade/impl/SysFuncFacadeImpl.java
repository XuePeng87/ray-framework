package cc.xuepeng.ray.framework.module.system.api.facade.impl;

import cc.xuepeng.ray.framework.core.common.util.TreeUtil;
import cc.xuepeng.ray.framework.module.system.api.facade.SysFuncFacade;
import cc.xuepeng.ray.framework.module.system.domain.converter.SysFuncConverter;
import cc.xuepeng.ray.framework.module.system.domain.dto.SysFuncDto;
import cc.xuepeng.ray.framework.module.system.domain.param.SysFuncParam;
import cc.xuepeng.ray.framework.module.system.domain.vo.SysFuncVo;
import cc.xuepeng.ray.framework.module.system.service.SysFuncService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 系统功能的业务处理门面实现类
 *
 * @author xuepeng
 */
@Component
public class SysFuncFacadeImpl implements SysFuncFacade {

    /**
     * 创建系统功能
     *
     * @param sysFuncParam 系统功能的请求对象
     * @return 是否创建成功
     */
    @Override
    public boolean create(final SysFuncParam sysFuncParam) {
        final SysFuncDto sysFuncDto = sysFuncConverter.paramToDto(sysFuncParam);
        return sysFuncService.create(sysFuncDto);
    }

    /**
     * 修改系统功能
     *
     * @param code         系统功能的编号
     * @param sysFuncParam 系统功能的请求对象
     * @return 是否修改成功
     */
    @Override
    public boolean update(final String code, final SysFuncParam sysFuncParam) {
        final SysFuncDto sysFuncDto = sysFuncConverter.paramToDto(sysFuncParam);
        sysFuncDto.setCode(code);
        return sysFuncService.update(sysFuncDto);
    }

    /**
     * 删除系统功能
     *
     * @param code 系统功能的编号
     * @return 是否删除成功
     */
    @Override
    public boolean delete(final String code) {
        return sysFuncService.delete(code);
    }

    /**
     * 根据编号查询系统功能
     *
     * @param code 系统功能的编号
     * @return 是否删除成功
     */
    @Override
    public SysFuncVo findByCode(final String code) {
        final SysFuncDto sysFuncDto = sysFuncService.findByCode(code);
        return sysFuncConverter.dtoToVo(sysFuncDto);
    }

    /**
     * 根据条件查询系统功能
     *
     * @param sysFuncParam 系统功能的请求对象
     * @return 系统功能的响应对象集合
     */
    @Override
    public List<SysFuncVo> treeByCondition(final SysFuncParam sysFuncParam) {
        final SysFuncDto sysFuncDto = sysFuncConverter.paramToDto(sysFuncParam);
        final List<SysFuncDto> sysFuncDtoList = sysFuncService.listByCondition(sysFuncDto);
        return sysFuncConverter.dtoListToVoList(TreeUtil.format(sysFuncDtoList));
    }

    /**
     * 系统功能的对象转换接口
     */
    @Resource
    private SysFuncConverter sysFuncConverter;

    /**
     * 系统功能的业务处理接口
     */
    @Resource
    private SysFuncService sysFuncService;

}
