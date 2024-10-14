package cc.xuepeng.ray.framework.module.system.api.facade.impl;

import cc.xuepeng.ray.framework.core.model.vo.PageVo;
import cc.xuepeng.ray.framework.module.system.api.facade.SysRoleFacade;
import cc.xuepeng.ray.framework.module.system.domain.converter.SysRoleConverter;
import cc.xuepeng.ray.framework.module.system.domain.dto.SysRoleDto;
import cc.xuepeng.ray.framework.module.system.domain.param.SysRoleParam;
import cc.xuepeng.ray.framework.module.system.domain.vo.SysRoleVo;
import cc.xuepeng.ray.framework.module.system.service.SysRoleFuncGrantService;
import cc.xuepeng.ray.framework.module.system.service.SysRoleService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 系统功能的业务处理门面实现类
 *
 * @author xuepeng
 */
@Component
public class SysRoleFacadeImpl implements SysRoleFacade {

    /**
     * 创建系统角色
     *
     * @param sysRoleParam 系统角色的请求对象
     * @return 是否创建成功
     */
    @Override
    public boolean create(final SysRoleParam sysRoleParam) {
        final SysRoleDto sysRoleDto = sysRoleConverter.paramToDto(sysRoleParam);
        return sysRoleService.create(sysRoleDto);
    }

    /**
     * 修改系统角色
     *
     * @param code         系统角色的编号
     * @param sysRoleParam 系统角色的请求对象
     * @return 是否修改成功
     */
    @Override
    public boolean update(final String code, final SysRoleParam sysRoleParam) {
        final SysRoleDto sysRoleDto = sysRoleConverter.paramToDto(sysRoleParam);
        sysRoleDto.setCode(code);
        return sysRoleService.update(sysRoleDto);
    }

    /**
     * 删除系统角色
     *
     * @param code 系统角色的编号
     * @return 是否删除成功
     */
    @Override
    public boolean delete(final String code) {
        return sysRoleService.delete(code);
    }

    /**
     * 根据编号查询系统角色
     *
     * @param code 系统角色的编号
     * @return 系统角色的响应对象
     */
    @Override
    public SysRoleVo findByCode(final String code) {
        final SysRoleDto sysRoleDto = sysRoleService.findByCode(code);
        return sysRoleConverter.dtoToVo(sysRoleDto);
    }

    /**
     * 根据编号批量查询系统角色
     *
     * @param codes 系统角色的编号集合
     * @return 系统角色的响应对象集合
     */
    @Override
    public List<SysRoleVo> findByCodes(final List<String> codes) {
        final List<SysRoleDto> sysRoleDtos = sysRoleService.findByCodes(codes);
        return sysRoleConverter.dtoListToVoList(sysRoleDtos);
    }

    /**
     * 根据条件分页查询系统角色
     *
     * @param sysRoleParam 系统角色的请求对象
     * @return 系统角色的响应对象集合
     */
    @Override
    public PageVo<SysRoleVo> pageByCondition(final SysRoleParam sysRoleParam) {
        final SysRoleDto sysRoleDto = sysRoleConverter.paramToDto(sysRoleParam);
        final Page<SysRoleDto> sysRoleDtos = sysRoleService.pageByCondition(sysRoleDto);
        return sysRoleConverter.dtoPageToVoPage(sysRoleDtos);
    }

    /**
     * 授权系统功能到系统角色
     *
     * @param code      系统角色的编号
     * @param funcCodes 系统功能的编号集合
     */
    @Override
    public void saveFuncToRole(final String code, final List<String> funcCodes) {
        sysRoleFuncGrantService.save(code, funcCodes);
    }

    /**
     * 查询系统角色所授权的系统功能
     *
     * @param code 系统角色的编号
     * @return 系统功能的编号集合
     */
    @Override
    public List<String> findFuncCodesByCode(final String code) {
        return sysRoleFuncGrantService.findFuncsByRoleCode(code);
    }

    /**
     * 系统角色对象转换接口
     */
    @Resource
    private SysRoleConverter sysRoleConverter;

    /**
     * 系统角色的业务处理接口
     */
    @Resource
    private SysRoleService sysRoleService;

    /**
     * 系统角色与功能关系的业务处理接口
     */
    @Resource
    private SysRoleFuncGrantService sysRoleFuncGrantService;


}
