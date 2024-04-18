package cc.xuepeng.ray.framework.module.system.service;

import cc.xuepeng.ray.framework.module.system.domain.dto.SysDictDto;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * 系统字典业务处理接口
 *
 * @author xuepeng
 */
public interface SysDictService {

    /**
     * 创建系统字典
     *
     * @param sysDictDto 系统字典数据传输类
     * @return 主键
     */
    Long create(final SysDictDto sysDictDto);

    /**
     * 修改系统字典
     *
     * @param sysDictDto 系统字典数据传输类
     * @return 是否修改成功
     */
    boolean update(final SysDictDto sysDictDto);

    /**
     * 根据主键查询系统字典
     *
     * @param id 主键
     * @return 系统字典数据传输类
     */
    SysDictDto findById(final long id);

    /**
     * 根据字典编号查询系统字典
     *
     * @param dictCode 字典编号
     * @return 系统字典数据传输类
     */
    SysDictDto findByDictCode(final String dictCode);

    /**
     * 根据主键删除系统字典
     *
     * @param id 主键
     * @return 是否删除成功
     */
    boolean deleteById(final long id);

    /**
     * 根据条件分页查询
     *
     * @param sysDictDto 系统字典数据传输类
     * @return 系统字典分页对象
     */
    Page<SysDictDto> pageByCondition(final SysDictDto sysDictDto);

}
