package cc.xuepeng.ray.framework.module.system.api.facade;

import cc.xuepeng.ray.framework.core.model.vo.PageVo;
import cc.xuepeng.ray.framework.module.system.domain.param.SysUserParam;
import cc.xuepeng.ray.framework.module.system.domain.vo.SysUserVo;

/**
 * 系统用户的业务处理门面接口
 *
 * @author xuepeng
 */
public interface SysUserFacade {

    /**
     * 创建系统用户
     *
     * @param sysUserParam 系统用户的请求对象
     * @return 是否创建成功
     */
    boolean create(final SysUserParam sysUserParam);

    /**
     * 修改系统用户
     *
     * @param code         系统用户的编号
     * @param sysUserParam 系统用户的请求对象
     * @return 是否修改成功
     */
    boolean update(final String code, final SysUserParam sysUserParam);

    /**
     * 删除系统用户
     *
     * @param code 系统用户的编号
     * @return 是否删除成功
     */
    boolean delete(final String code);

    /**
     * 根据编号查询系统用户
     *
     * @param code 系统用户的编号
     * @return 系统用户的响应对象
     */
    SysUserVo findByCode(final String code);

    /**
     * 根据条件分页查询系统用户
     *
     * @param sysUserParam 系统用户的请求对象
     * @return 系统用户的响应对象
     */
    PageVo<SysUserVo> pageByCondition(final SysUserParam sysUserParam);

}
