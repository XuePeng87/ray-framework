package cc.xuepeng.ray.framework.core.auth.model;

import lombok.*;

import java.io.Serial;
import java.io.Serializable;

/**
 * 当前登录人角色的实体类
 *
 * @author xuepeng
 */
@Data
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class CurrentUserRole implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private Long id;

    /**
     * 唯一标识
     */
    private String roleCode;

    /**
     * 名称
     */
    private String roleName;

}
