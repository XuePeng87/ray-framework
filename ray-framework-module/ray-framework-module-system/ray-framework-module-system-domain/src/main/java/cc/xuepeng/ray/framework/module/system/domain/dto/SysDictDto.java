package cc.xuepeng.ray.framework.module.system.domain.dto;

import cc.xuepeng.ray.framework.core.model.dto.BaseDto;
import cc.xuepeng.ray.framework.module.system.domain.enums.SysDictStatus;
import lombok.*;

/**
 * 系统字典的数据传输类
 *
 * @author xuepeng
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class SysDictDto extends BaseDto {

    /**
     * 字典名称
     */
    private String dictName;

    /**
     * 字段编号
     */
    private String dictCode;

    /**
     * 字典描述
     */
    private String dictDesc;

    /**
     * 状态：0=停用；1=启用
     */
    private SysDictStatus dictStatus;

}
