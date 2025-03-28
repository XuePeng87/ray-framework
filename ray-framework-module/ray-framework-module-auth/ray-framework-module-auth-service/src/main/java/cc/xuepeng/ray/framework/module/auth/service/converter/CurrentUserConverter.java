package cc.xuepeng.ray.framework.module.auth.service.converter;

import cc.xuepeng.ray.framework.module.system.service.dto.SysDeptDto;
import cc.xuepeng.ray.framework.module.system.service.dto.SysFuncDto;
import cc.xuepeng.ray.framework.module.system.service.dto.SysRoleDto;
import cc.xuepeng.ray.framework.module.system.service.dto.SysUserDto;
import cc.xuepeng.ray.framework.sdk.auth.model.CurrentUser;
import cc.xuepeng.ray.framework.sdk.auth.model.CurrentUserDept;
import cc.xuepeng.ray.framework.sdk.auth.model.CurrentUserFunc;
import cc.xuepeng.ray.framework.sdk.auth.model.CurrentUserRole;

import java.util.List;

/**
 * CurrentUserConverter接口定义了一组用于系统登录用户对象转换的方法。
 * 该接口主要用于将系统内部的各种数据传输对象（DTO）转换为当前用户模型对象，
 * 以便在认证和授权模块中使用。
 * <p>
 * 主要功能包括：
 * 1. 将系统用户数据传输对象（SysUserDto）转换为当前用户对象（CurrentUser）。
 * 2. 将系统部门数据传输对象（SysDeptDto）转换为当前用户部门对象（CurrentUserDept）。
 * 3. 将系统角色数据传输对象列表（List<SysRoleDto>）转换为当前用户角色对象列表（List<CurrentUserRole>）。
 * 4. 将系统功能数据传输对象列表（List<SysFuncDto>）转换为当前用户功能对象列表（List<CurrentUserFunc>）。
 * <p>
 * 这些转换方法使得系统能够方便地将内部数据结构映射到认证和授权模块所需的用户模型，
 * 从而支持用户认证、权限校验等功能。
 *
 * @author xuepeng
 */
public interface CurrentUserConverter {

    /**
     * 将系统用户数据传输对象转换为当前用户对象。
     *
     * @param sysUserDto 系统用户数据传输对象
     * @return 当前用户对象
     */
    CurrentUser sysUserToCurrentUser(final SysUserDto sysUserDto);

    /**
     * 将系统部门数据传输对象转换为当前用户部门对象。
     *
     * @param sysDeptDto 系统部门数据传输对象
     * @return 当前用户部门对象
     */
    CurrentUserDept sysDeptToCurrentUserDept(final SysDeptDto sysDeptDto);

    /**
     * 将系统角色数据传输对象列表转换为当前用户角色对象列表。
     *
     * @param sysRoleDtos 系统角色数据传输对象列表
     * @return 当前用户角色对象列表
     */
    List<CurrentUserRole> sysRoleListToCurrentUserRoleList(final List<SysRoleDto> sysRoleDtos);

    /**
     * 将系统功能数据传输对象列表转换为当前用户功能对象列表。
     *
     * @param sysFuncDtos 系统功能数据传输对象列表
     * @return 当前用户功能对象列表
     */
    List<CurrentUserFunc> sysFuncListToCurrentUserFuncList(final List<SysFuncDto> sysFuncDtos);

}
