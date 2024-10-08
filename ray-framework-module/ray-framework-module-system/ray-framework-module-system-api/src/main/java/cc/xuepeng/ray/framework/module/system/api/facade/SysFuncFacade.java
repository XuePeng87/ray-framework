package cc.xuepeng.ray.framework.module.system.api.facade;

import cc.xuepeng.ray.framework.module.system.domain.param.SysFuncParam;
import cc.xuepeng.ray.framework.module.system.domain.vo.SysFuncVo;

import java.util.List;

/**
 * 系统功能的业务处理门面接口
 *
 * @author xuepeng
 */
public interface SysFuncFacade {

    /**
     * 创建系统功能
     *
     * @param sysFuncParam 系统功能的请求对象
     * @return 是否创建成功
     */
    boolean create(final SysFuncParam sysFuncParam);

    /**
     * 修改系统功能
     *
     * @param code         系统功能的编号
     * @param sysFuncParam 系统功能的请求对象
     * @return 是否修改成功
     */
    boolean update(final String code, final SysFuncParam sysFuncParam);

    /**
     * 删除系统功能
     *
     * @param code 系统功能的编号
     * @return 是否删除成功
     */
    boolean delete(final String code);

    /**
     * 根据编号查询系统功能
     *
     * @param code 系统功能的编号
     * @return 是否删除成功
     */
    SysFuncVo findByCode(final String code);

    /**
     * 根据条件查询系统功能
     *
     * @param sysFuncParam 系统功能的请求对象
     * @return 系统功能的响应对象集合
     */
    List<SysFuncVo> treeByCondition(final SysFuncParam sysFuncParam);

}
