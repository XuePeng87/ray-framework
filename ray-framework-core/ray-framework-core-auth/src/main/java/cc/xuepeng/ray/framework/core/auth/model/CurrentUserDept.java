package cc.xuepeng.ray.framework.core.auth.model;

import lombok.*;

import java.io.Serial;
import java.io.Serializable;

/**
 * 当前登录人部门的实体类
 *
 * @author xuepeng
 */
@Data
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class CurrentUserDept implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private Long id;

    /**
     * 编号
     */
    private String deptCode;

    /**
     * 父级主键
     */
    private Long pid;

    /**
     * 名称
     */
    private String deptName;

}
