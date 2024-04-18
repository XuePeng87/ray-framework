package cc.xuepeng.ray.framework.module.system.domain.vo;

import cc.xuepeng.ray.framework.core.model.vo.BaseVo;
import cc.xuepeng.ray.framework.module.system.domain.enums.SysDictContentStatus;
import lombok.*;

/**
 * 系统字典项数据响应类
 *
 * @author xuepeng
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString
public class SysDictContentVo extends BaseVo {

    /**
     * 字典表主键
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
     * 状态：0=停用；1=启用；
     */
    private SysDictContentStatus contentStatus;
    
}
