package cc.xuepeng.ray.framework.core.auth.service.impl;

import cc.xuepeng.ray.framework.core.auth.model.CurrentUserFunc;
import cc.xuepeng.ray.framework.core.auth.model.CurrentUserRole;
import cc.xuepeng.ray.framework.core.auth.service.AuthService;
import cn.dev33.satoken.stp.StpInterface;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 权限认证接口的实现类
 *
 * @author xuepeng
 */
@Component
public class StpInterfaceImpl implements StpInterface {

    /**
     * 获取当前登录用户的功能
     *
     * @param o 账号主键
     * @param s 账号类型
     * @return 当前登录用户的功能
     */
    @Override
    public List<String> getPermissionList(Object o, String s) {
        return authService.getCurrentUser()
                .getFuncs()
                .stream()
                .map(CurrentUserFunc::getFuncCode)
                .toList();
    }

    /**
     * 获取当前登录用户的角色
     *
     * @param o 账号主键
     * @param s 账号类型
     * @return 当前登录用户的角色
     */
    @Override
    public List<String> getRoleList(Object o, String s) {
        return authService.getCurrentUser()
                .getRoles()
                .stream()
                .map(CurrentUserRole::getRoleCode)
                .toList();
    }

    /**
     * 鉴权服务
     */
    @Resource
    private AuthService authService;

}
