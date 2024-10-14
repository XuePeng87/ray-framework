package cc.xuepeng.ray.framework.module.system.api.facade;

import cc.xuepeng.ray.framework.core.model.vo.PageVo;
import cc.xuepeng.ray.framework.module.system.domain.param.SysRoleParam;
import cc.xuepeng.ray.framework.module.system.domain.vo.SysRoleVo;

import java.util.List;

/**
 * 系统角色的业务处理门面接口
 *
 * @author xuepeng
 */
public interface SysRoleFacade {

    /**
     * 创建系统角色
     *
     * @param sysRoleParam 系统角色的请求对象
     * @return 是否创建成功
     */
    boolean create(final SysRoleParam sysRoleParam);

    /**
     * 修改系统角色
     *
     * @param code         系统角色的编号
     * @param sysRoleParam 系统角色的请求对象
     * @return 是否修改成功
     */
    boolean update(final String code, final SysRoleParam sysRoleParam);

    /**
     * 删除系统角色
     *
     * @param code 系统角色的编号
     * @return 是否删除成功
     */
    boolean delete(final String code);

    /**
     * 根据编号查询系统角色
     *
     * @param code 系统角色的编号
     * @return 系统角色的响应对象
     */
    SysRoleVo findByCode(final String code);

    /**
     * 根据编号批量查询系统角色
     *
     * @param codes 系统角色的编号集合
     * @return 系统角色的响应对象集合
     */
    List<SysRoleVo> findByCodes(final List<String> codes);

    /**
     * 根据条件分页查询系统角色
     *
     * @param sysRoleParam 系统角色的请求对象
     * @return 系统角色的响应对象集合
     */
    PageVo<SysRoleVo> pageByCondition(final SysRoleParam sysRoleParam);

    /**
     * 授权系统功能到系统角色
     *
     * @param code      系统角色的编号
     * @param funcCodes 系统功能的编号集合
     */
    void saveFuncToRole(final String code, final List<String> funcCodes);

    /**
     * 查询系统角色所授权的系统功能
     *
     * @param code 系统角色的编号
     * @return 系统功能的编号集合
     */
    List<String> findFuncCodesByCode(final String code);

}
