package cc.xuepeng.ray.framework.module.system.domain.vo;

import cc.xuepeng.ray.framework.core.model.vo.BaseVo;
import lombok.*;

/**
 * 系统字典项的数据响应类
 *
 * @author xuepeng
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class SysDictItemVo extends BaseVo {

    /**
     * 字典编号
     */
    private String parentCode;

    /**
     * 字典项编号
     */
    private String code;

    /**
     * 字典项名称
     */
    private String name;

    /**
     * 排序
     */
    private Long sort;

    /**
     * 描述
     */
    private String remark;
    
}
