package cc.xuepeng.ray.framework.module.system.api.facade;

import cc.xuepeng.ray.framework.core.model.vo.PageVo;
import cc.xuepeng.ray.framework.module.system.domain.param.SysDictParam;

/**
 * 系统字典的业务处理门面接口
 *
 * @author xuepeng
 */
public interface SysDictFacade {

    /**
     * 根据条件分野查询系统字典
     *
     * @param sysDictParam 系统字典的数据请求对象
     * @return 系统字典的数据传输对象集合
     */
    PageVo<SysDictParam> pageByCondition(final SysDictParam sysDictParam);

}
