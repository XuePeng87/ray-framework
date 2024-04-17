package cc.xuepeng.ray.framework.core.auth.service.impl;

import cc.xuepeng.ray.framework.core.auth.exception.NotLoginException;
import cc.xuepeng.ray.framework.core.auth.model.CurrentUser;
import cc.xuepeng.ray.framework.core.auth.service.AuthService;
import cn.dev33.satoken.stp.StpUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Component;

/**
 * SaToken的业务处理实现类
 * 实现了AuthService接口，为ApiLog提供获取登录用户能力
 *
 * @author xuepeng
 */
@Component
@Slf4j
public class SaTokenServiceImpl implements AuthService {

    /**
     * Session Key
     */
    private static final String SESSION_KEY = "user";

    /**
     * @return 当前用户是否登录
     */
    @Override
    public boolean isLogin() {
        return StpUtil.isLogin();
    }

    /**
     * @return 判断当前登录用户是否是管理员（超管或者系统管理员）
     */
    @Override
    public boolean isAdmin() {
        final CurrentUser currentUser = getCurrentUser();
        return currentUser.getAdmin();
    }

    /**
     * @return 获取当前登录用户
     */
    @Override
    public CurrentUser getCurrentUser() {
        final Object result = StpUtil.getSession().get(SESSION_KEY);
        if (ObjectUtils.isEmpty(result)) {
            throw new NotLoginException("未登录无法执行该操作");
        }
        return (CurrentUser) result;
    }

}
