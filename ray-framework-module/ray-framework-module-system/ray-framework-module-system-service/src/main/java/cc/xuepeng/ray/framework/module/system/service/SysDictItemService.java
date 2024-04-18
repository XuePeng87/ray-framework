package cc.xuepeng.ray.framework.module.system.service;

import cc.xuepeng.ray.framework.module.system.domain.dto.SysDictItemDto;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.Collection;
import java.util.List;

/**
 * 系统字典项业务处理接口
 *
 * @author xuepeng
 */
public interface SysDictItemService {


    /**
     * 创建系统字典项
     *
     * @param sysDictItemDto 系统字典项数据传输类
     * @return 是否创建成功
     */
    boolean create(final SysDictItemDto sysDictItemDto);

    /**
     * 修改系统字典项
     *
     * @param sysDictItemDto 系统字典项数据传输类
     * @return 是否修改成功
     */
    boolean update(final SysDictItemDto sysDictItemDto);

    /**
     * 根据主键删除
     *
     * @param id 主键
     * @return 是否删除成功
     */
    boolean deleteById(final long id);

    /**
     * 根据系统字典主键查询系统字典项
     *
     * @param pid 系统字典主键
     * @return 系统字典项集合
     */
    List<SysDictItemDto> findByPid(final long pid);

    /**
     * 根据系统字典主键查询系统字典项主键
     *
     * @param pid 系统字典主键
     * @return 系统字典项主键集合
     */
    List<Long> findIdsByPid(final long pid);

    /**
     * 根据系统字典主键集合查询系统字典项主键
     *
     * @param pidList 系统字典主键集合
     * @return 系统字典项主键集合
     */
    List<Long> findIdsByPids(final Collection<Long> pidList);

    /**
     * 根据ID查询
     *
     * @param id 主键
     * @return 系统字典项数据传输类
     */
    SysDictItemDto findById(final long id);

    /**
     * 分页查询
     *
     * @param sysDictItemDto 系统字典项数据传输类
     * @return 分页对象
     */
    Page<SysDictItemDto> pageByCondition(final SysDictItemDto sysDictItemDto);

}
