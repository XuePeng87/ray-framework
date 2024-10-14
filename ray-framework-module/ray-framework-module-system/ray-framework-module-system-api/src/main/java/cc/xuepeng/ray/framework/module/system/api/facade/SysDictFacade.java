package cc.xuepeng.ray.framework.module.system.api.facade;

import cc.xuepeng.ray.framework.core.model.vo.PageVo;
import cc.xuepeng.ray.framework.module.system.domain.param.SysDictParam;
import cc.xuepeng.ray.framework.module.system.domain.vo.SysDictVo;

import java.util.List;

/**
 * 系统字典的业务处理门面接口
 *
 * @author xuepeng
 */
public interface SysDictFacade {

    /**
     * 创建系统字典
     *
     * @param sysDictParam 系统字典的请求对象
     * @return 是否创建成功
     */
    boolean create(final SysDictParam sysDictParam);

    /**
     * 修改系统字典
     *
     * @param code         系统字典的编号
     * @param sysDictParam 系统字典的请求对象
     * @return 是否修改成功
     */
    boolean update(final String code, final SysDictParam sysDictParam);

    /**
     * 删除系统字典
     *
     * @param codes 系统字典的编号集合
     * @return 是否删除成功
     */
    boolean delete(final List<String> codes);

    /**
     * 根据编号查询系统字典
     *
     * @param code 系统字典的编号
     * @return 系统字典的响应对象
     */
    SysDictVo findByCode(final String code);

    /**
     * 根据条件分页查询系统字典
     *
     * @param sysDictParam 系统字典的数据请求对象
     * @return 系统字典的响应对象集合
     */
    PageVo<SysDictVo> pageByCondition(final SysDictParam sysDictParam);

}
