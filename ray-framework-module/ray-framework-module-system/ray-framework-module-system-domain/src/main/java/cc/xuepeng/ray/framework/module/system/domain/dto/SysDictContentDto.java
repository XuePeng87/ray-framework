package cc.xuepeng.ray.framework.module.system.domain.dto;

import cc.xuepeng.ray.framework.core.model.dto.BaseDto;
import cc.xuepeng.ray.framework.module.system.domain.enums.SysDictContentStatus;
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
public class SysDictContentDto extends BaseDto {

    /**
     * 字典项表主键
     */
    private Long pid;

    /**
     * 字典项名称
     */
    private String contentName;

    /**
     * 字典项编号
     */
    private String contentCode;

    /**
     * 排序
     */
    private Long contentSort;

    /**
     * 描述
     */
    private String contentRemark;

    /**
     * 状态：0=停用；1=启用
     */
    private SysDictContentStatus contentStatus;
}
