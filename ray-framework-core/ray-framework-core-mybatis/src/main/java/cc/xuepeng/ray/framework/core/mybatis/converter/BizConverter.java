package cc.xuepeng.ray.framework.core.mybatis.converter;

import cc.xuepeng.ray.framework.core.common.converter.BaseConverter;
import cc.xuepeng.ray.framework.core.model.vo.PageVo;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * ORM实体类的转换器
 *
 * @param <P> Param对象
 * @param <D> Dto对象
 * @param <E> Entity对象
 * @param <V> Vo对象
 */
public interface BizConverter<P, D, E, V> extends BaseConverter<P, D, E, V> {

    /**
     * Entity分页转换成Dto分页
     *
     * @param entityPage Entity分页对象
     * @return Dto分页对象
     */
    Page<D> entityPageToDtoPage(final Page<E> entityPage);

    /**
     * Dto分页转换成Vo分页
     *
     * @param dtoPage Dto分页对象
     * @return Vo分页对象
     */
    PageVo<V> dtoPageToVoPage(final Page<D> dtoPage);

}
