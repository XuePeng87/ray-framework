package cc.xuepeng.ray.framework.module.auth.domain.converter;

import cc.xuepeng.ray.framework.core.auth.model.CurrentUser;
import cc.xuepeng.ray.framework.core.auth.model.CurrentUserDept;
import cc.xuepeng.ray.framework.core.auth.model.CurrentUserFunc;
import cc.xuepeng.ray.framework.core.auth.model.CurrentUserRole;
import cc.xuepeng.ray.framework.module.system.domain.dto.SysDeptDto;
import cc.xuepeng.ray.framework.module.system.domain.dto.SysFuncDto;
import cc.xuepeng.ray.framework.module.system.domain.dto.SysRoleDto;
import cc.xuepeng.ray.framework.module.system.domain.dto.SysUserDto;

import java.util.List;

/**
 * 系统登录用户对象转换接口
 *
 * @author xuepeng
 */
public interface CurrentUserConverter {

    CurrentUser sysUserToCurrentUser(final SysUserDto sysUserDto);

    CurrentUserDept sysDeptToCurrentUserDept(final SysDeptDto sysDeptDto);

    List<CurrentUserRole> sysRoleListToCurrentUserRoleList(final List<SysRoleDto> sysRoleDtos);

    List<CurrentUserFunc> sysFuncListToCurrentUserFuncList(final List<SysFuncDto> sysFuncDtos);

}
