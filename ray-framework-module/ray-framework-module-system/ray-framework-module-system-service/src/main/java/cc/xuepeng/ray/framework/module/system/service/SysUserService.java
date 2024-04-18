package cc.xuepeng.ray.framework.module.system.service;

import cc.xuepeng.ray.framework.module.system.domain.dto.SysUserDto;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.List;

/**
 * 系统用户的业务处理接口
 *
 * @author xuepeng
 */
public interface SysUserService {

    /**
     * 创建系统用户
     *
     * @param sysUserDto 系统用户的数据传输对象
     * @return 登录密码
     */
    String create(final SysUserDto sysUserDto);

    /**
     * 修改系统用户
     *
     * @param sysUserDto 系统用户的数据传输对象
     * @return 是否修改成功
     */
    boolean update(final SysUserDto sysUserDto);

    /**
     * 根据编号删除系统用户
     *
     * @param code 系统用户的编号
     * @return 是否删除成功
     */
    boolean delete(final String code);

    /**
     * 根据编号查询系统用户
     *
     * @param code 系统用户的编号
     * @return 系统用户的数据传输对象
     */
    SysUserDto findByCode(final String code);

    /**
     * 根据条件查询系统用户
     *
     * @param sysUserDto 系统用户的数据传输对象
     * @return 系统用户的数据传输对象集合
     */
    List<SysUserDto> listByCondition(final SysUserDto sysUserDto);

    /**
     * 根据条件分页查询系统用户
     *
     * @param sysUserDto 系统用户的数据传输对象
     * @return 系统用户的数据传输对象集合
     */
    Page<SysUserDto> pageByCondition(final SysUserDto sysUserDto);

}