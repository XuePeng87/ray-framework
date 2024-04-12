package cc.xuepeng.ray.framework.core.auth.model;

import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 当前登录人的实体类
 *
 * @author xuepeng
 */
@Data
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class CurrentUser implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private Long id;

    /**
     * 编号
     */
    private String userCode;

    /**
     * 帐号
     */
    private String userAccount;

    /**
     * 姓名
     */
    private String userName;

    /**
     * 邮箱
     */
    private String userEmail;

    /**
     * 电话号码
     */
    private String userPhone;

    /**
     * 头像
     */
    private String userAvatar;

    /**
     * 注册IP
     */
    private String regeditIp;

    /**
     * 登录IP
     */
    private String loginIp;

    /**
     * 登录IP归属地
     */
    private String loginIpInfo;

    /**
     * 最后登录时间
     */
    private LocalDateTime loginLastTime;

    /**
     * 是否是管理员（超级管理员和系统管理员）
     */
    private Boolean admin;

    /**
     * 部门
     */
    private CurrentUserDept dept;

    /**
     * 角色
     */
    private transient List<CurrentUserRole> roles;

    /**
     * 控制台功能
     */
    private List<CurrentUserFunc> funcs;

}
