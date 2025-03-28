package cc.xuepeng.ray.framework.module.auth.api.facade.impl;

import cc.xuepeng.ray.framework.module.auth.api.converter.SysAuthConverter;
import cc.xuepeng.ray.framework.module.auth.api.facade.SysAuthFacade;
import cc.xuepeng.ray.framework.module.auth.api.request.SysLoginRequest;
import cc.xuepeng.ray.framework.module.auth.service.SysAuthService;
import cc.xuepeng.ray.framework.module.auth.service.dto.SysLoginDto;
import cc.xuepeng.ray.framework.sdk.auth.model.CurrentUser;
import cc.xuepeng.ray.framework.sdk.verifycode.client.ImageVerifyCodeClient;
import cc.xuepeng.ray.framework.sdk.verifycode.enums.VerifyCodeType;
import cc.xuepeng.ray.framework.sdk.verifycode.model.ImageVerifyCode;
import jakarta.annotation.Resource;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

@Component
public class SysAuthFacadeImpl implements SysAuthFacade {

    /**
     * @return 创建图片验证码
     */
    @Override
    public ImageVerifyCode createLoginImageVerifyCode() {
        return imageVerifyCodeClient.generate(VerifyCodeType.IMAGE_LOGIN);
    }


    /**
     * 系统登录
     *
     * @param sysLoginRequest 系统登录的请求对象
     * @return 访问令牌
     */
    @Override
    public String login(final SysLoginRequest sysLoginRequest) {
        if (!StringUtils.equals(sysLoginRequest.getCode(), "wanneng")) {
            // 校验验证码
            imageVerifyCodeClient.verify(
                    sysLoginRequest.getUuid(),
                    sysLoginRequest.getCode(),
                    VerifyCodeType.IMAGE_LOGIN
            );
        }
        // 登录
        final SysLoginDto sysLoginDto = sysAuthConverter.requestToDto(sysLoginRequest);
        return sysAuthService.login(sysLoginDto);
    }

    /**
     * @return 获取当前登录用户
     */
    @Override
    public CurrentUser getCurrentUser() {
        return sysAuthService.getCurrentUser();
    }

    /**
     * 系统登出
     */
    @Override
    public void logout() {
        sysAuthService.logout();
    }

    /**
     * 图片验证码的工具
     */
    @Resource
    private ImageVerifyCodeClient imageVerifyCodeClient;

    /**
     * 系统认证对象转换接口
     */
    @Resource
    private SysAuthConverter sysAuthConverter;

    /**
     * 系统认证的业务处理接口
     */
    @Resource
    private SysAuthService sysAuthService;

}
