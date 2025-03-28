package cc.xuepeng.ray.framework.module.system.service.dto;

import cc.xuepeng.ray.framework.core.common.domain.dto.BaseDto;
import cc.xuepeng.ray.framework.core.mybatis.enums.BizStatus;
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
     * 编号
     */
    private String code;

    /**
     * 名称
     */
    private String name;

    /**
     * 字典值
     */
    private String value;

    /**
     * 状态：0=停用；1=启用
     */
    private BizStatus status;

    /**
     * 描述
     */
    private String remark;

}
