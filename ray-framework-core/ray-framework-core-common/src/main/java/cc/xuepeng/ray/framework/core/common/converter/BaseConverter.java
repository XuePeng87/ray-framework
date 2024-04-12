package cc.xuepeng.ray.framework.core.common.converter;

import java.util.List;

/**
 * * 实体类的转换器
 *
 * @param <P> Param对象
 * @param <D> Dto对象
 * @param <E> Entity对象
 * @param <V> Vo对象
 */
public interface BaseConverter<P, D, E, V> {

    /**
     * Param转换成Dto
     *
     * @param param Param对象
     * @return Dto对象
     */
    D paramToDto(final P param);

    /**
     * Dto转换成Entity
     *
     * @param dto Dto对象
     * @return Entity对象
     */
    E dtoToEntity(final D dto);

    /**
     * Entity转换成Dto
     *
     * @param entity Entity对象
     * @return Dto对象
     */
    D entityToDto(final E entity);

    /**
     * Dto转换成Vo
     *
     * @param dto Dto对象
     * @return Vo对象
     */
    V dtoToVo(final D dto);

    /**
     * Dto集合转换成Entity集合
     *
     * @param dtoList Dto集合对象
     * @return Entity集合对象
     */
    List<E> dtoListToEntityList(final List<D> dtoList);

    /**
     * Entity集合转换成Dto集合
     *
     * @param entityList Entity集合对象
     * @return Dto集合对象
     */
    List<D> entityListToDtoList(final List<E> entityList);

    /**
     * Dto集合转换成Vo集合
     *
     * @param dtoList Dto集合
     * @return Vo集合
     */
    List<V> dtoListToVoList(final List<D> dtoList);

}
