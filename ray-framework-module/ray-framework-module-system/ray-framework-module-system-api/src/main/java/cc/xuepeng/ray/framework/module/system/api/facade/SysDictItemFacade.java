package cc.xuepeng.ray.framework.module.system.api.facade;

import cc.xuepeng.ray.framework.core.model.vo.PageVo;
import cc.xuepeng.ray.framework.module.system.domain.param.SysDictItemParam;
import cc.xuepeng.ray.framework.module.system.domain.vo.SysDictItemVo;

import java.util.List;

/**
 * 系统字典项的业务处理门面接口
 *
 * @author xuepeng
 */
public interface SysDictItemFacade {

    /**
     * 创建系统字典项
     *
     * @param sysDictItemParam 系统字典项的数据请求类
     * @return 是否创建成功
     */
    boolean create(final SysDictItemParam sysDictItemParam);

    /**
     * 修改系统字典项
     *
     * @param code             系统字典项的编号
     * @param sysDictItemParam 系统字典项的数据请求类
     * @return 是否修改成功
     */
    boolean update(final String code, final SysDictItemParam sysDictItemParam);

    /**
     * 删除系统字典项
     *
     * @param codes 系统字典项的编号集合
     * @return 是否删除成功
     */
    boolean delete(final List<String> codes);

    /**
     * 根据编号查询系统字典项
     *
     * @param code 系统字典项的编号
     * @return 系统字典项的数据响应对象
     */
    SysDictItemVo findByCode(final String code);

    /**
     * 根据条件分页查询系统字典项
     *
     * @param sysDictItemParam 系统字典项的数据请求对象
     * @return 系统字典项的数据响应对象集合
     */
    PageVo<SysDictItemVo> pageByCondition(final SysDictItemParam sysDictItemParam);

}
