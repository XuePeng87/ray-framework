package cc.xuepeng.ray.framework.module.system.api.facade.impl;

import cc.xuepeng.ray.framework.core.model.vo.PageVo;
import cc.xuepeng.ray.framework.module.system.api.facade.SysDictFacade;
import cc.xuepeng.ray.framework.module.system.domain.converter.SysDictConverter;
import cc.xuepeng.ray.framework.module.system.domain.dto.SysDictDto;
import cc.xuepeng.ray.framework.module.system.domain.param.SysDictParam;
import cc.xuepeng.ray.framework.module.system.domain.vo.SysDictVo;
import cc.xuepeng.ray.framework.module.system.service.SysDictService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 系统字典的业务处理门面实现类
 *
 * @author xuepeng
 */
@Component
public class SysDictFacadeImpl implements SysDictFacade {

    /**
     * 创建系统字典
     *
     * @param sysDictParam 系统字典的数据请求类
     * @return 是否创建成功
     */
    @Override
    public boolean create(final SysDictParam sysDictParam) {
        final SysDictDto sysDictDto = sysDictConverter.paramToDto(sysDictParam);
        return sysDictService.create(sysDictDto);
    }

    /**
     * 修改系统字典
     *
     * @param code         系统字典的编号
     * @param sysDictParam 系统字典的数据请求类
     * @return 是否修改成功
     */
    @Override
    public boolean update(final String code, final SysDictParam sysDictParam) {
        final SysDictDto sysDictDto = sysDictConverter.paramToDto(sysDictParam);
        sysDictDto.setCode(code);
        return sysDictService.update(sysDictDto);
    }

    /**
     * 删除系统字典
     *
     * @param codes 系统字典的编号集合
     * @return 是否删除成功
     */
    @Override
    public boolean delete(final List<String> codes) {
        return sysDictService.deleteByCodes(codes);
    }

    /**
     * 根据编号查询系统字典
     *
     * @param code 系统字典的编号
     * @return 系统字典的数据响应对象
     */
    @Override
    public SysDictVo findByCode(final String code) {
        final SysDictDto sysDictDto = sysDictService.findByCode(code);
        return sysDictConverter.dtoToVo(sysDictDto);
    }

    /**
     * 根据条件分页查询系统字典
     *
     * @param sysDictParam 系统字典的数据请求对象
     * @return 系统字典的数据传输对象集合
     */
    @Override
    public PageVo<SysDictVo> pageByCondition(final SysDictParam sysDictParam) {
        final SysDictDto sysDictDto = sysDictConverter.paramToDto(sysDictParam);
        final Page<SysDictDto> sysDictDtos = sysDictService.pageByCondition(sysDictDto);
        return sysDictConverter.dtoPageToVoPage(sysDictDtos);
    }

    /**
     * 系统字典对象转换接口
     */
    @Resource
    private SysDictConverter sysDictConverter;

    /**
     * 系统字典的业务处理接口
     */
    @Resource
    private SysDictService sysDictService;

}
