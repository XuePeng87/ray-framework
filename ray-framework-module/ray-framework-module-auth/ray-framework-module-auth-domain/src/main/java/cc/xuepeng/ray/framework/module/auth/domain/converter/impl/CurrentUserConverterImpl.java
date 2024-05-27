package cc.xuepeng.ray.framework.module.auth.domain.converter.impl;

import cc.xuepeng.ray.framework.core.auth.model.CurrentUser;
import cc.xuepeng.ray.framework.core.auth.model.CurrentUserDept;
import cc.xuepeng.ray.framework.core.auth.model.CurrentUserFunc;
import cc.xuepeng.ray.framework.core.auth.model.CurrentUserRole;
import cc.xuepeng.ray.framework.module.auth.domain.converter.CurrentUserConverter;
import cc.xuepeng.ray.framework.module.system.domain.dto.SysDeptDto;
import cc.xuepeng.ray.framework.module.system.domain.dto.SysFuncDto;
import cc.xuepeng.ray.framework.module.system.domain.dto.SysRoleDto;
import cc.xuepeng.ray.framework.module.system.domain.dto.SysUserDto;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.BooleanUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * 系统登录用户对象转换实现类
 *
 * @author xuepeng
 */
@Component
public class CurrentUserConverterImpl implements CurrentUserConverter {

    @Override
    public CurrentUser sysUserToCurrentUser(final SysUserDto sysUserDto) {
        final CurrentUser currentUser = new CurrentUser();
        currentUser.setCode(sysUserDto.getCode());
        currentUser.setPhoneNumber(sysUserDto.getPhoneNumber());
        currentUser.setName(sysUserDto.getName());
        currentUser.setEmail(sysUserDto.getEmail());
        currentUser.setAvatar(sysUserDto.getAvatar());
        return currentUser;
    }

    @Override
    public CurrentUserDept sysDeptToCurrentUserDept(final SysDeptDto sysDeptDto) {
        final CurrentUserDept currentUserDept = new CurrentUserDept();
        currentUserDept.setCode(sysDeptDto.getCode());
        currentUserDept.setName(sysDeptDto.getName());
        return currentUserDept;
    }

    @Override
    public List<CurrentUserRole> sysRoleListToCurrentUserRoleList(final List<SysRoleDto> sysRoleDtos) {
        final List<CurrentUserRole> currentUserRoles = new ArrayList<>();
        for (SysRoleDto sysRoleDto : sysRoleDtos) {
            final CurrentUserRole currentUserRole = new CurrentUserRole();
            currentUserRole.setCode(sysRoleDto.getCode());
            currentUserRole.setName(sysRoleDto.getName());
            currentUserRoles.add(currentUserRole);
        }
        return currentUserRoles;
    }

    @Override
    public List<CurrentUserFunc> sysFuncListToCurrentUserFuncList(final List<SysFuncDto> sysFuncDtos) {
        final List<CurrentUserFunc> currentUserFuncs = new ArrayList<>();
        for (SysFuncDto sysFuncDto : sysFuncDtos) {
            final CurrentUserFunc currentUserFunc = new CurrentUserFunc();
            currentUserFunc.setPath(sysFuncDto.getPath());
            if (BooleanUtils.isFalse(sysFuncDto.getLinkable())) {
                currentUserFunc.setComponent(sysFuncDto.getComponent());
            }
            currentUserFunc.setRedirect(sysFuncDto.getRedirect());
            currentUserFunc.setName(sysFuncDto.getPath());
            // 设置元数据
            final CurrentUserFunc.CurrentUserFuncMeta currentUserFuncMeta = new CurrentUserFunc.CurrentUserFuncMeta();
            currentUserFuncMeta.setTitle(sysFuncDto.getName());
            currentUserFuncMeta.setIcon(sysFuncDto.getIcon());
            currentUserFuncMeta.setHidden(!sysFuncDto.getVisible());
            currentUserFuncMeta.setKeepAlive(sysFuncDto.getCacheable());
            currentUserFuncMeta.setAlwaysShow(sysFuncDto.getAlwaysShow());
            currentUserFunc.setMeta(currentUserFuncMeta);
            // 添加到数据
            currentUserFuncs.add(currentUserFunc);
            if (CollectionUtils.isNotEmpty(sysFuncDto.getChildren())) {
                currentUserFunc.setChildren(this.sysFuncListToCurrentUserFuncList(sysFuncDto.getChildren()));
            }
        }
        return currentUserFuncs;
    }

}
