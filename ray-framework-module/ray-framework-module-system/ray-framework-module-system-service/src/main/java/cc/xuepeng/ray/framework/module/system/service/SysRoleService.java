package cc.xuepeng.ray.framework.module.system.service;

import cc.xuepeng.ray.framework.module.system.domain.dto.SysRoleDto;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.List;

/**
 * 系统角色的业务处理接口
 *
 * @author xuepeng
 */
public interface SysRoleService {

    /**
     * 创建系统角色
     *
     * @param sysRoleDto 系统角色的数据传输对象
     * @return 是否创建成功
     */
    boolean create(final SysRoleDto sysRoleDto);

    /**
     * 修改系统角色
     *
     * @param sysRoleDto 系统角色的数据传输对象
     * @return 是否修改成功
     */
    boolean update(final SysRoleDto sysRoleDto);

    /**
     * 删除系统角色
     *
     * @param code 系统角色的编号
     * @return 是否删除成功
     */
    boolean delete(final String code);

    /**
     * 根据主键查询系统角色
     *
     * @param code 系统角色的编号
     * @return 系统角色的数据传输对象
     */
    SysRoleDto findByCode(final String code);

    /**
     * 根据条件分页查询系统角色
     *
     * @param sysRoleDto 系统角色的数据传输对象
     * @return 系统角色的数据传输对象集合
     */
    Page<SysRoleDto> pageByCondition(final SysRoleDto sysRoleDto);

    /**
     * 授权系统用户
     *
     * @param id        系统角色的主键
     * @param userCodes 系统用户的编号集合
     */
    void grantUsers(final long id, final List<String> userCodes);

    /**
     * 查询角色下的用户
     *
     * @param id 系统角色的主键
     * @return 系统用户的编号集合
     */
    List<String> findUsers(final long id);

    /**
     * 授权系统功能
     *
     * @param id      系统角色的主键
     * @param funcIds 系统功能的主键集合
     */
    void grantFuncs(final long id, final List<Long> funcIds);

    /**
     * 查询系统角色下已授权的系统功能
     *
     * @param id 系统角色的主键
     * @return 系统功能的主键集合
     */
    List<Long> findFuncs(final long id);

}
