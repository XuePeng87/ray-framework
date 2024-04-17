package cc.xuepeng.ray.framework.core.auth.service;

import cc.xuepeng.ray.framework.core.auth.model.CurrentUser;

/**
 * 认证的业务处理接口
 *
 * @author xuepeng
 */
public interface AuthService {

    /**
     * @return 当前用户是否登录
     */
    boolean isLogin();


    /**
     * @return 判断当前登录用户是否是管理员（超管或者系统管理员）
     */
    boolean isAdmin();

    /**
     * @return 获取当前登录用户
     */
    CurrentUser getCurrentUser();

}
