package cc.xuepeng.ray.framework.module.system.domain.dto;

import cc.xuepeng.ray.framework.core.model.dto.BaseDto;
import lombok.*;

/**
 * 系统字典项的数据传输类
 *
 * @author xuepeng
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class SysDictItemDto extends BaseDto {

    /**
     * 字典编号
     */
    private String parentCode;

    /**
     * 名称
     */
    private String name;

    /**
     * 编号
     */
    private String code;

    /**
     * 排序
     */
    private Integer sequence;

    /**
     * 描述
     */
    private String remark;

}
