package cc.xuepeng.ray.framework.module.system.service;

import cc.xuepeng.ray.framework.module.system.domain.dto.SysDictItemDto;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.List;

/**
 * 系统字典项的业务处理接口
 *
 * @author xuepeng
 */
public interface SysDictItemService {


    /**
     * 创建系统字典项
     *
     * @param sysDictItemDto 系统字典项的数据传输对象
     * @return 是否创建成功
     */
    boolean create(final SysDictItemDto sysDictItemDto);

    /**
     * 修改系统字典项
     *
     * @param sysDictItemDto 系统字典项的数据传输对象
     * @return 是否修改成功
     */
    boolean update(final SysDictItemDto sysDictItemDto);

    /**
     * 根据编号删除系统字典项
     *
     * @param code 编号
     * @return 是否删除成功
     */
    boolean deleteByCode(final String code);

    /**
     * 根据编号查询系统字典项
     *
     * @param code 编号
     * @return 系统字典项的数据传输对象
     */
    SysDictItemDto findByCode(final String code);

    /**
     * 根据系统字典编号查询系统字典项
     *
     * @param dictCode 系统字典编号
     * @return 系统字典项的数据传输对象集合
     */
    List<SysDictItemDto> findByDictCode(final String dictCode);

    /**
     * 分页查询系统字典项
     *
     * @param sysDictItemDto 系统字典项的数据传输对象
     * @return 系统字典项的数据传输对象集合
     */
    Page<SysDictItemDto> pageByCondition(final SysDictItemDto sysDictItemDto);

}
