package cc.xuepeng.ray.framework.module.system.api.facade;

import cc.xuepeng.ray.framework.module.system.domain.param.SysDeptParam;
import cc.xuepeng.ray.framework.module.system.domain.vo.SysDeptVo;

import java.util.List;

/**
 * 系统部门的门面接口
 *
 * @author xuepeng
 */
public interface SysDeptFacade {

    /**
     * 创建系统部门
     *
     * @param sysDeptParam 系统部门的请求对象
     * @return 是否创建成功
     */
    boolean create(final SysDeptParam sysDeptParam);

    /**
     * 修改系统部门
     *
     * @param code         系统部门的编号
     * @param sysDeptParam 系统部门的请求对象
     * @return 是否修改成功
     */
    boolean update(final String code, final SysDeptParam sysDeptParam);

    /**
     * 删除系统部门
     *
     * @param code 系统部门的编号
     * @return 是否删除成功
     */
    boolean delete(final String code);

    /**
     * 根据编号查询系统部门
     *
     * @param code 系统部门的编号
     * @return 系统部门的响应对象
     */
    SysDeptVo findByCode(final String code);

    /**
     * 根据条件查询系统部门
     *
     * @param sysDeptParam 系统部门的请求对象
     * @return 系统部门的响应对象集合
     */
    List<SysDeptVo> treeByCondition(final SysDeptParam sysDeptParam);

}
