package cc.xuepeng.ray.framework.module.auth.service.impl;

import cc.xuepeng.ray.framework.module.auth.service.SysAuthService;
import cc.xuepeng.ray.framework.module.auth.service.converter.CurrentUserConverter;
import cc.xuepeng.ray.framework.module.auth.service.dto.SysLoginDto;
import cc.xuepeng.ray.framework.module.auth.service.exception.SysLoginFailedException;
import cc.xuepeng.ray.framework.module.system.service.decorator.func.SysFuncFormat;
import cc.xuepeng.ray.framework.module.system.service.dto.SysDeptDto;
import cc.xuepeng.ray.framework.module.system.service.dto.SysFuncDto;
import cc.xuepeng.ray.framework.module.system.service.dto.SysRoleDto;
import cc.xuepeng.ray.framework.module.system.service.dto.SysUserDto;
import cc.xuepeng.ray.framework.module.system.service.exception.user.SysUserNotFoundException;
import cc.xuepeng.ray.framework.module.system.service.service.*;
import cc.xuepeng.ray.framework.sdk.auth.model.CurrentUser;
import cc.xuepeng.ray.framework.sdk.auth.model.CurrentUserDept;
import cc.xuepeng.ray.framework.sdk.auth.model.CurrentUserFunc;
import cc.xuepeng.ray.framework.sdk.auth.model.CurrentUserRole;
import cc.xuepeng.ray.framework.sdk.auth.service.IdentificationService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 系统认证的业务处理类
 *
 * @author xuepeng
 */
@Component
public class SysAuthServiceImpl implements SysAuthService {

    /**
     * 系统登录
     *
     * @param sysLoginDto 系统登录的数据传输对象
     * @return 访问令牌
     */
    @Override
    public String login(final SysLoginDto sysLoginDto) {
        try {
            // 设置用户
            final SysUserDto sysUserDto = sysUserService.findByPhoneNumberAndPassword(
                    sysLoginDto.getPhoneNumber(),
                    sysLoginDto.getPassword()
            );
            final CurrentUser currentUser = currentUserConverter.sysUserToCurrentUser(sysUserDto);
            // 设置部门
            final SysDeptDto sysDeptDto = sysDeptService.findByCode(sysUserDto.getDeptCode());
            final CurrentUserDept currentUserDept = currentUserConverter.sysDeptToCurrentUserDept(sysDeptDto);
            currentUser.setDept(currentUserDept);
            // 设置角色
            final List<String> roleCodes = sysRoleUserGrantService.findRolesByUserCode(sysUserDto.getCode());
            final List<SysRoleDto> sysRoleDtos = sysRoleService.findByCodes(roleCodes);
            final List<CurrentUserRole> currentUserRole = currentUserConverter.sysRoleListToCurrentUserRoleList(sysRoleDtos);
            currentUser.setRoles(currentUserRole);
            // 设置功能
            final List<String> funcCodes = sysRoleFuncGrantService.findFuncsByRoleCodes(roleCodes);
            final List<SysFuncDto> sysFuncDtos = sysFuncService.findByCodes(funcCodes);
            final List<SysFuncDto> funcTree = sysFuncFormat.tree(sysFuncDtos);
            final List<CurrentUserFunc> currentUserFunc = currentUserConverter.sysFuncListToCurrentUserFuncList(funcTree);
            currentUser.setFuncs(currentUserFunc);
            // 设置权限
            final List<String> permissions = sysFuncDtos.stream().map(SysFuncDto::getPermission).collect(Collectors.toList());
            currentUser.setPermissions(permissions);
            // 登录系统
            return identificationService.login(currentUser);
        } catch (SysUserNotFoundException e) {
            throw new SysLoginFailedException("用户名或密码不正确");
        }
    }

    /**
     * @return 获取当前登录人
     */
    @Override
    public CurrentUser getCurrentUser() {
        return identificationService.getCurrentUser();
    }

    /**
     * 系统登出
     */
    @Override
    public void logout() {
        identificationService.logout();
    }

    /**
     * 认证的业务处理接口
     */
    @Resource
    private IdentificationService identificationService;

    /**
     * 系统用户的业务处理接口
     */
    @Resource
    private SysUserService sysUserService;

    /**
     * 系统部门的业务处理接口
     */
    @Resource
    private SysDeptService sysDeptService;

    /**
     * 系统角色与用户关系的业务处理接口
     */
    @Resource
    private SysRoleUserGrantService sysRoleUserGrantService;

    /**
     * 系统角色与功能关系的业务处理接口
     */
    @Resource
    private SysRoleFuncGrantService sysRoleFuncGrantService;

    /**
     * 系统角色的业务处理接口
     */
    @Resource
    private SysRoleService sysRoleService;

    /**
     * 系统功能的业务处理接口
     */
    @Resource
    private SysFuncService sysFuncService;

    /**
     * 系统功能格式化接口
     */
    @Resource
    private SysFuncFormat sysFuncFormat;

    /**
     * 系统登录用户对象转换接口
     */
    @Resource
    private CurrentUserConverter currentUserConverter;

}
