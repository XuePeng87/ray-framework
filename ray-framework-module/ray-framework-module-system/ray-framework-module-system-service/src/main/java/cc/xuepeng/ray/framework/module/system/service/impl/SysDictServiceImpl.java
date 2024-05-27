package cc.xuepeng.ray.framework.module.system.service.impl;

import cc.xuepeng.ray.framework.core.common.util.ExistsUtil;
import cc.xuepeng.ray.framework.core.common.util.RandomUtil;
import cc.xuepeng.ray.framework.core.mybatis.consts.EntityConst;
import cc.xuepeng.ray.framework.core.mybatis.consts.QueryConst;
import cc.xuepeng.ray.framework.core.mybatis.util.PageUtil;
import cc.xuepeng.ray.framework.core.mybatis.util.QueryWrapperUtil;
import cc.xuepeng.ray.framework.module.system.dao.SysDictDao;
import cc.xuepeng.ray.framework.module.system.domain.converter.SysDictConverter;
import cc.xuepeng.ray.framework.module.system.domain.dto.SysDictDto;
import cc.xuepeng.ray.framework.module.system.domain.entity.SysDict;
import cc.xuepeng.ray.framework.module.system.service.SysDictService;
import cc.xuepeng.ray.framework.module.system.service.exception.dict.SysDictDuplicateException;
import cc.xuepeng.ray.framework.module.system.service.exception.dict.SysDictNotFoundException;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import jakarta.annotation.Resource;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import java.util.List;

/**
 * 系统字典的业务处理实现类
 *
 * @author xuepeng
 */
@Component
public class SysDictServiceImpl
        extends ServiceImpl<SysDictDao, SysDict>
        implements SysDictService {

    /**
     * 创建系统字典
     *
     * @param sysDictDto 系统字典的数据传输对象
     * @return 是否创建成功
     */
    @Override
    public boolean create(final SysDictDto sysDictDto) {
        final String name = sysDictDto.getName();
        final String value = sysDictDto.getValue();
        if (this.checkNameExisted(StringUtils.EMPTY, name)) {
            throw new SysDictDuplicateException("系统字典名称[" + name + "]已存在");
        }
        if (this.checkValueExisted(StringUtils.EMPTY, value)) {
            throw new SysDictDuplicateException("系统字典值[" + value + "]已存在");
        }
        sysDictDto.setCode(RandomUtil.get32UUID());
        final SysDict sysDict = sysDictConverter.dtoToEntity(sysDictDto);
        return super.save(sysDict);
    }

    /**
     * 修改系统字典
     *
     * @param sysDictDto 系统字典的数据传输对象
     * @return 是否修改成功
     */
    @Override
    public boolean update(final SysDictDto sysDictDto) {
        final String code = sysDictDto.getCode();
        final String name = sysDictDto.getName();
        final String value = sysDictDto.getValue();
        if (this.checkNameExisted(code, name)) {
            throw new SysDictDuplicateException("系统字典名称[" + name + "]已存在");
        }
        if (this.checkValueExisted(code, value)) {
            throw new SysDictDuplicateException("系统字典值[" + value + "]已存在");
        }
        final SysDict sysDict = sysDictConverter.dtoToEntity(sysDictDto);
        final QueryWrapper<SysDict> wrapper = this.createQueryWrapper(code);
        return super.update(sysDict, wrapper);
    }

    /**
     * 根据编号删除系统字典
     *
     * @param code 编号
     * @return 是否删除成功
     */
    @Override
    public boolean deleteByCode(final String code) {
        final QueryWrapper<SysDict> wrapper = this.createQueryWrapper(code);
        return super.remove(wrapper);
    }

    /**
     * 根据编号查询系统字典
     *
     * @param code 编号
     * @return 系统字典的数据传输对象
     */
    @Override
    public SysDictDto findByCode(final String code) {
        final QueryWrapper<SysDict> wrapper = this.createQueryWrapper(code);
        final SysDict sysDict = super.getOne(wrapper, QueryConst.QUERY_NULL_THROW_EX);
        if (ObjectUtils.isEmpty(sysDict)) {
            throw new SysDictNotFoundException("无法根据编号[" + code + "]查询到系统字典");
        }
        return sysDictConverter.entityToDto(sysDict);
    }

    /**
     * 根据条件分页查询系统字典
     *
     * @param sysDictDto 系统字典的数据传输对象
     * @return 系统字典的数据传输对象集合
     */
    @Override
    public Page<SysDictDto> pageByCondition(final SysDictDto sysDictDto) {
        final QueryWrapper<SysDict> wrapper = this.createQueryWrapper(sysDictDto);
        final Page<SysDict> page = PageUtil.createPage(sysDictDto);
        final Page<SysDict> sysDicts = super.page(page, wrapper);
        return sysDictConverter.entityPageToDtoPage(sysDicts);
    }

    /**
     * 检测系统字典名称是否已存在
     *
     * @param code 编号
     * @param name 名称
     * @return 系统字典名称是否已存在
     */
    private boolean checkNameExisted(final String code, final String name) {
        final QueryWrapper<SysDict> wrapper = this.createQueryWrapper();
        final List<SysDict> sysDicts = super.list(wrapper.lambda().eq(SysDict::getName, name));
        return ExistsUtil.exists(
                sysDicts,
                StringUtils.isBlank(code) ? StringUtils.EMPTY : code, EntityConst.CODE
        );
    }

    /**
     * 检测系统字典值是否已存在
     *
     * @param code  编号
     * @param value 字典值
     * @return 系统字典值是否已存在
     */
    private boolean checkValueExisted(final String code, final String value) {
        final QueryWrapper<SysDict> wrapper = this.createQueryWrapper();
        final List<SysDict> sysDicts = super.list(wrapper.lambda().eq(SysDict::getValue, value));
        return ExistsUtil.exists(
                sysDicts,
                StringUtils.isBlank(code) ? StringUtils.EMPTY : code, EntityConst.CODE
        );
    }

    /**
     * @return 创建QueryWrapper
     */
    private QueryWrapper<SysDict> createQueryWrapper() {
        return QueryWrapperUtil.createQueryWrapper();
    }

    /**
     * 创建带编号的QueryWrapper
     *
     * @param code 编号
     * @return 带编号的QueryWrapper
     */
    private QueryWrapper<SysDict> createQueryWrapper(final String code) {
        final QueryWrapper<SysDict> wrapper = this.createQueryWrapper();
        final LambdaQueryWrapper<SysDict> lambda = wrapper.lambda();
        lambda.eq(StringUtils.isNotBlank(code), SysDict::getCode, code);
        return QueryWrapperUtil.createQueryWrapper();
    }

    /**
     * 创建带条件的QueryWrapper
     *
     * @param sysDictDto 系统字典的数据传输对象
     * @return 带条件的QueryWrapper
     */
    private QueryWrapper<SysDict> createQueryWrapper(final SysDictDto sysDictDto) {
        final QueryWrapper<SysDict> wrapper = this.createQueryWrapper();
        final SysDict sysDict = sysDictConverter.dtoToEntity(sysDictDto);
        final LambdaQueryWrapper<SysDict> lambda = wrapper.lambda();
        lambda.like(StringUtils.isNotBlank(sysDict.getCode()), SysDict::getCode, sysDict.getCode());
        lambda.like(StringUtils.isNotBlank(sysDict.getName()), SysDict::getName, sysDict.getName());
        return QueryWrapperUtil.createQueryWrapper();
    }

    /**
     * 系统字典对象转换接口
     */
    @Resource
    private SysDictConverter sysDictConverter;

}
