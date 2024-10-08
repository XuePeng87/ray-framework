package cc.xuepeng.ray.framework.module.system.api.facade.impl;

import cc.xuepeng.ray.framework.core.model.vo.PageVo;
import cc.xuepeng.ray.framework.module.system.api.facade.SysDictItemFacade;
import cc.xuepeng.ray.framework.module.system.domain.converter.SysDictItemConverter;
import cc.xuepeng.ray.framework.module.system.domain.dto.SysDictItemDto;
import cc.xuepeng.ray.framework.module.system.domain.param.SysDictItemParam;
import cc.xuepeng.ray.framework.module.system.domain.vo.SysDictItemVo;
import cc.xuepeng.ray.framework.module.system.service.SysDictItemService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 系统字典项的业务处理门面实现类
 *
 * @author xuepeng
 */
@Component
public class SysDictItemFacadeImpl implements SysDictItemFacade {

    /**
     * 创建系统字典项
     *
     * @param sysDictItemParam 系统字典项的数据请求类
     * @return 是否创建成功
     */
    @Override
    public boolean create(final SysDictItemParam sysDictItemParam) {
        final SysDictItemDto sysDictItemDto = sysDictItemConverter.paramToDto(sysDictItemParam);
        return sysDictItemService.create(sysDictItemDto);
    }

    /**
     * 修改系统字典项
     *
     * @param code             系统字典项的编号
     * @param sysDictItemParam 系统字典项的数据请求类
     * @return 是否修改成功
     */
    @Override
    public boolean update(final String code, final SysDictItemParam sysDictItemParam) {
        final SysDictItemDto sysDictItemDto = sysDictItemConverter.paramToDto(sysDictItemParam);
        sysDictItemDto.setCode(code);
        return sysDictItemService.update(sysDictItemDto);
    }

    /**
     * 删除系统字典项
     *
     * @param codes 系统字典项的编号集合
     * @return 是否删除成功
     */
    @Override
    public boolean delete(final List<String> codes) {
        return sysDictItemService.deleteByCodes(codes);
    }

    /**
     * 根据编号查询系统字典项
     *
     * @param code 系统字典项的编号
     * @return 系统字典项的数据响应对象
     */
    @Override
    public SysDictItemVo findByCode(final String code) {
        final SysDictItemDto sysDictItemDto = sysDictItemService.findByCode(code);
        return sysDictItemConverter.dtoToVo(sysDictItemDto);
    }

    /**
     * 根据条件分页查询系统字典项
     *
     * @param sysDictItemParam 系统字典项的数据请求对象
     * @return 系统字典项的数据响应对象集合
     */
    @Override
    public PageVo<SysDictItemVo> pageByCondition(final SysDictItemParam sysDictItemParam) {
        final SysDictItemDto sysDictItemDto = sysDictItemConverter.paramToDto(sysDictItemParam);
        final Page<SysDictItemDto> sysDictItemDtos = sysDictItemService.pageByCondition(sysDictItemDto);
        return sysDictItemConverter.dtoPageToVoPage(sysDictItemDtos);
    }

    /**
     * 系统字典项的对象转换接口
     */
    @Resource
    private SysDictItemConverter sysDictItemConverter;

    /**
     * 系统字典项的业务处理接口
     */
    @Resource
    private SysDictItemService sysDictItemService;

}
