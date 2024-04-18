package cc.xuepeng.ray.framework.module.system.service;

import java.util.List;

/**
 * 系统角色的业务处理接口
 *
 * @author xuepeng
 */
public interface SysRoleGrantService {

    /**
     * 授权系统用户
     *
     * @param code      编号
     * @param userCodes 系统用户的编号集合
     */
    void grantUsers(final String code, final List<String> userCodes);

    /**
     * 查询系统角色下的系统用户
     *
     * @param code 编号
     * @return 系统用户的编号集合
     */
    List<String> findUsers(final String code);

    /**
     * 授权系统功能
     *
     * @param code      编号
     * @param funcCodes 系统功能的编号集合
     */
    void grantFuncs(final String code, final List<String> funcCodes);

    /**
     * 查询系统角色下的系统功能
     *
     * @param code 编号
     * @return 系统功能的编号集合
     */
    List<Long> findFuncs(final String code);

}
