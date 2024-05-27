package cc.xuepeng.ray.framework.module.system.api.facade.impl;

import cc.xuepeng.ray.framework.core.model.vo.PageVo;
import cc.xuepeng.ray.framework.module.system.api.facade.SysDictFacade;
import cc.xuepeng.ray.framework.module.system.domain.param.SysDictParam;
import org.springframework.stereotype.Component;

/**
 * 系统字典的业务处理门面实现类
 *
 * @author xuepeng
 */
@Component
public class SysDictFacadeImpl implements SysDictFacade {

    /**
     * 根据条件分野查询系统字典
     *
     * @param sysDictParam 系统字典的数据请求对象
     * @return 系统字典的数据传输对象集合
     */
    @Override
    public PageVo<SysDictParam> pageByCondition(final SysDictParam sysDictParam) {
        return null;
    }

}
