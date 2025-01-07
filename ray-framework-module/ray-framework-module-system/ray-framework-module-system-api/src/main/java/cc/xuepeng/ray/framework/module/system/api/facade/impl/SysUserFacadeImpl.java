package cc.xuepeng.ray.framework.module.system.api.facade.impl;

import cc.xuepeng.ray.framework.core.model.vo.PageVo;
import cc.xuepeng.ray.framework.module.system.api.facade.SysUserFacade;
import cc.xuepeng.ray.framework.module.system.domain.converter.SysUserConverter;
import cc.xuepeng.ray.framework.module.system.domain.dto.SysUserDto;
import cc.xuepeng.ray.framework.module.system.domain.param.SysUserParam;
import cc.xuepeng.ray.framework.module.system.domain.vo.SysUserVo;
import cc.xuepeng.ray.framework.module.system.service.SysUserService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

/**
 * 系统功能的业务处理门面实现类
 *
 * @author xuepeng
 */
@Component
public class SysUserFacadeImpl implements SysUserFacade {

    /**
     * 创建系统用户
     *
     * @param sysUserParam 系统用户的请求对象
     * @return 是否创建成功
     */
    public boolean create(final SysUserParam sysUserParam) {
        final SysUserDto sysUserDto = sysUserConverter.paramToDto(sysUserParam);
        return sysUserService.create(sysUserDto);
    }

    /**
     * 修改系统用户
     *
     * @param code         系统用户的编号
     * @param sysUserParam 系统用户的请求对象
     * @return 是否修改成功
     */
    public boolean update(final String code, final SysUserParam sysUserParam) {
        final SysUserDto sysUserDto = sysUserConverter.paramToDto(sysUserParam);
        sysUserDto.setCode(code);
        return sysUserService.update(sysUserDto);
    }

    /**
     * 删除系统用户
     *
     * @param code 系统用户的编号
     * @return 是否删除成功
     */
    public boolean delete(final String code) {
        return sysUserService.delete(code);
    }

    /**
     * 根据编号查询系统用户
     *
     * @param code 系统用户的编号
     * @return 系统用户的响应对象
     */
    public SysUserVo findByCode(final String code) {
        final SysUserDto sysUserDto = sysUserService.findByCode(code);
        return sysUserConverter.dtoToVo(sysUserDto);
    }

    /**
     * 根据条件分页查询系统用户
     *
     * @param sysUserParam 系统用户的请求对象
     * @return 系统用户的响应对象
     */
    public PageVo<SysUserVo> pageByCondition(final SysUserParam sysUserParam) {
        final SysUserDto sysUserDto = sysUserConverter.paramToDto(sysUserParam);
        final Page<SysUserDto> sysUserDtos = sysUserService.pageByCondition(sysUserDto);
        return sysUserConverter.dtoPageToVoPage(sysUserDtos);
    }

    /**
     * 根据编号重置密码
     *
     * @param code 编号
     * @return 是否重置成功
     */
    @Override
    public boolean resetPassword(final String code) {
        return sysUserService.resetPassword(code);
    }

    /**
     * 系统用户对象转换接口
     */
    @Resource
    private SysUserConverter sysUserConverter;

    /**
     * 系统用户的业务处理接口
     */
    @Resource
    private SysUserService sysUserService;

}
