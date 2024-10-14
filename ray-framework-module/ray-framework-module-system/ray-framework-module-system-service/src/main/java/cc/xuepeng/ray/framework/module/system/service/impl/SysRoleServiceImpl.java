package cc.xuepeng.ray.framework.module.system.service.impl;

import cc.xuepeng.ray.framework.core.auth.annotation.CreateUser;
import cc.xuepeng.ray.framework.core.auth.annotation.ModifyUser;
import cc.xuepeng.ray.framework.core.common.util.ExistsUtil;
import cc.xuepeng.ray.framework.core.common.util.RandomUtil;
import cc.xuepeng.ray.framework.core.mybatis.consts.EntityConst;
import cc.xuepeng.ray.framework.core.mybatis.consts.QueryConst;
import cc.xuepeng.ray.framework.core.mybatis.util.PageUtil;
import cc.xuepeng.ray.framework.core.mybatis.util.QueryWrapperUtil;
import cc.xuepeng.ray.framework.module.system.dao.SysRoleDao;
import cc.xuepeng.ray.framework.module.system.domain.converter.SysRoleConverter;
import cc.xuepeng.ray.framework.module.system.domain.dto.SysRoleDto;
import cc.xuepeng.ray.framework.module.system.domain.entity.SysRole;
import cc.xuepeng.ray.framework.module.system.service.SysRoleService;
import cc.xuepeng.ray.framework.module.system.service.exception.role.SysRoleDuplicateException;
import cc.xuepeng.ray.framework.module.system.service.exception.role.SysRoleNotFoundException;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import jakarta.annotation.Resource;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * 系统角色的业务处理实现类
 *
 * @author xuepeng
 */
@Component
public class SysRoleServiceImpl
        extends ServiceImpl<SysRoleDao, SysRole>
        implements SysRoleService {

    /**
     * 创建系统角色
     *
     * @param sysRoleDto 系统角色的数据传输对象
     * @return 是否创建成功
     */
    @CreateUser
    @Override
    public boolean create(final SysRoleDto sysRoleDto) {
        final String name = sysRoleDto.getName();
        if (this.checkNameExisted(StringUtils.EMPTY, name)) {
            throw new SysRoleDuplicateException("系统角色名称[" + name + "]已存在");
        }
        sysRoleDto.setCode(RandomUtil.get32UUID());
        final SysRole sysRole = sysRoleConverter.dtoToEntity(sysRoleDto);
        return super.save(sysRole);
    }

    /**
     * 修改系统角色
     *
     * @param sysRoleDto 系统角色的数据传输对象
     * @return 是否修改成功
     */
    @ModifyUser
    @Override
    public boolean update(final SysRoleDto sysRoleDto) {
        final String code = sysRoleDto.getCode();
        final String name = sysRoleDto.getName();
        if (this.checkNameExisted(code, name)) {
            throw new SysRoleDuplicateException("系统角色名称[" + name + "]已存在");
        }
        final SysRole sysRole = sysRoleConverter.dtoToEntity(sysRoleDto);
        final QueryWrapper<SysRole> wrapper = this.createQueryWrapper(code);
        return super.update(sysRole, wrapper);
    }

    /**
     * 删除系统角色
     *
     * @param code 系统角色的编号
     * @return 是否删除成功
     */
    @Override
    public boolean delete(final String code) {
        // TODO 判断角色下是否有用户和功能
        final QueryWrapper<SysRole> wrapper = this.createQueryWrapper(code);
        return super.remove(wrapper);
    }

    /**
     * 根据主键查询系统角色
     *
     * @param code 系统角色的编号
     * @return 系统角色的数据传输对象Ø
     */
    @Override
    public SysRoleDto findByCode(final String code) {
        final QueryWrapper<SysRole> wrapper = this.createQueryWrapper(code);
        final SysRole sysRole = super.getOne(wrapper, QueryConst.QUERY_NULL_THROW_EX);
        if (ObjectUtils.isEmpty(sysRole)) {
            throw new SysRoleNotFoundException("无法根据编号[" + code + "]查询到系统角色");
        }
        return sysRoleConverter.entityToDto(sysRole);
    }

    /**
     * 根据主键查询系统角色
     *
     * @param codes 系统角色的编号集合
     * @return 系统角色的数据传输对象集合
     */
    @Override
    public List<SysRoleDto> findByCodes(final List<String> codes) {
        if (CollectionUtils.isEmpty(codes)) {
            return new ArrayList<>();
        }
        final QueryWrapper<SysRole> wrapper = this.createQueryWrapper();
        final List<SysRole> sysRoles = super.list(wrapper.lambda().in(SysRole::getCode, codes));
        return sysRoleConverter.entityListToDtoList(sysRoles);
    }

    /**
     * 根据条件分页查询系统角色
     *
     * @param sysRoleDto 系统角色的数据传输对象
     * @return 系统角色的数据传输对象集合
     */
    @Override
    public Page<SysRoleDto> pageByCondition(final SysRoleDto sysRoleDto) {
        final QueryWrapper<SysRole> wrapper = this.createQueryWrapper(sysRoleDto);
        final Page<SysRole> page = PageUtil.createPage(sysRoleDto);
        final Page<SysRole> sysRoles = super.page(page, wrapper);
        return sysRoleConverter.entityPageToDtoPage(sysRoles);
    }

    /**
     * 检测系统角色名称是否已存在
     *
     * @param code 编号
     * @param name 名称
     * @return 系统角色名称是否已存在
     */
    private boolean checkNameExisted(final String code, final String name) {
        final QueryWrapper<SysRole> wrapper = this.createQueryWrapper();
        final List<SysRole> sysRoles = super.list(wrapper.lambda().eq(SysRole::getName, name));
        return ExistsUtil.exists(
                sysRoles,
                StringUtils.isBlank(code) ? StringUtils.EMPTY : code, EntityConst.CODE
        );
    }

    /**
     * @return 创建QueryWrapper
     */
    private QueryWrapper<SysRole> createQueryWrapper() {
        return QueryWrapperUtil.createQueryWrapper();
    }

    /**
     * 创建带编号的QueryWrapper
     *
     * @param code 编号
     * @return 带编号的QueryWrapper
     */
    private QueryWrapper<SysRole> createQueryWrapper(final String code) {
        final QueryWrapper<SysRole> wrapper = this.createQueryWrapper();
        final LambdaQueryWrapper<SysRole> lambda = wrapper.lambda();
        lambda.eq(StringUtils.isNotBlank(code), SysRole::getCode, code);
        return wrapper;
    }

    /**
     * 创建带条件的QueryWrapper
     *
     * @param sysRoleDto 系统角色的数据传输对象
     * @return 带条件的QueryWrapper
     */
    private QueryWrapper<SysRole> createQueryWrapper(final SysRoleDto sysRoleDto) {
        final QueryWrapper<SysRole> wrapper = QueryWrapperUtil.createQueryWrapper(sysRoleDto);
        final SysRole sysRole = sysRoleConverter.dtoToEntity(sysRoleDto);
        final LambdaQueryWrapper<SysRole> lambda = wrapper.lambda();
        lambda.eq(StringUtils.isNotBlank(sysRole.getCode()), SysRole::getCode, sysRole.getCode());
        lambda.eq(ObjectUtils.isNotEmpty(sysRole.getStatus()), SysRole::getStatus, sysRole.getStatus());
        lambda.like(StringUtils.isNotBlank(sysRole.getRemark()), SysRole::getRemark, sysRole.getRemark());
        lambda.orderByAsc(SysRole::getSequence);
        return wrapper;
    }

    /**
     * 系统角色对象转换接口
     */
    @Resource
    private SysRoleConverter sysRoleConverter;

}
