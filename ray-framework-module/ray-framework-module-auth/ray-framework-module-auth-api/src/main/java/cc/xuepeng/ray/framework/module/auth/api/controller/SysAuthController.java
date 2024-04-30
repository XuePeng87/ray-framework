package cc.xuepeng.ray.framework.module.auth.api.controller;

import cc.xuepeng.ray.framework.core.auth.model.CurrentUser;
import cc.xuepeng.ray.framework.core.model.result.DefaultResultFactory;
import cc.xuepeng.ray.framework.core.model.result.Result;
import cc.xuepeng.ray.framework.core.web.controller.BaseController;
import cc.xuepeng.ray.framework.core.web.limit.IPLimit;
import cc.xuepeng.ray.framework.core.web.log.annotation.LoginLog;
import cc.xuepeng.ray.framework.core.web.log.annotation.LogoutLog;
import cc.xuepeng.ray.framework.core.web.log.annotation.OperateLog;
import cc.xuepeng.ray.framework.core.web.log.enums.SysOperateLogAction;
import cc.xuepeng.ray.framework.module.auth.api.facade.SysAuthFacade;
import cc.xuepeng.ray.framework.module.auth.domain.param.SysLoginParam;
import cc.xuepeng.ray.framework.sdk.verifycode.model.ImageVerifyCode;
import cn.dev33.satoken.annotation.SaCheckLogin;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * 系统认证的API接口
 *
 * @author xuepeng
 */
@RestController
@RequestMapping("/v1/auth")
@Slf4j
@Validated
@SaCheckLogin
public class SysAuthController extends BaseController {

    /**
     * @return 创建登录图片验证码
     */
    @GetMapping("/v1/login-vc")
    @OperateLog(module = "系统管理", func = "身份认证", remark = "生成登录图片验证码",
            action = SysOperateLogAction.CREATE, persistent = false)
    @IPLimit
    public Result<ImageVerifyCode> createLoginImageVerifyCode() {
        return DefaultResultFactory.success("创建登录图片验证码", sysAuthFacade.createLoginImageVerifyCode());
    }

    /**
     * 系统登录
     *
     * @param sysLoginParam 系统登录的请求对象
     * @return 访问令牌
     */
    @PostMapping("/v1/login")
    @LoginLog
    @IPLimit
    public Result<String> login(@Validated @RequestBody final SysLoginParam sysLoginParam) {
        final String accessToken = sysAuthFacade.login(sysLoginParam);
        return DefaultResultFactory.success("登录成功", accessToken);
    }

    @GetMapping("/v1/current-user")
    @OperateLog(module = "系统管理", func = "身份认证", remark = "获取当前登录人", action = SysOperateLogAction.QUERY, persistent = false)
    public Result<CurrentUser> getCurrentUser() {
        return DefaultResultFactory.success("获取当前登录人", sysAuthFacade.getCurrentUser());
    }

    /**
     * @return 登出系统
     */
    @PostMapping("/v1/logout")
    @LogoutLog
    public Result<String> logout() {
        sysAuthFacade.logout();
        return DefaultResultFactory.success("登出成功", StringUtils.EMPTY);
    }

    /**
     * 系统认证的业务处理门面接口
     */
    @Resource
    private SysAuthFacade sysAuthFacade;

}
