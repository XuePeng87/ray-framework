package cc.xuepeng.ray.framework.module.auth.api.controller;

import cc.xuepeng.ray.framework.core.model.result.DefaultResultFactory;
import cc.xuepeng.ray.framework.core.model.result.Result;
import cc.xuepeng.ray.framework.core.web.controller.BaseController;
import cc.xuepeng.ray.framework.core.web.limit.IPLimit;
import cc.xuepeng.ray.framework.core.web.log.annotation.OperateLog;
import cc.xuepeng.ray.framework.core.web.log.enums.SysOperateLogAction;
import cc.xuepeng.ray.framework.sdk.verifycode.client.ImageVerifyCodeClient;
import cc.xuepeng.ray.framework.sdk.verifycode.enums.VerifyCodeType;
import cc.xuepeng.ray.framework.sdk.verifycode.model.ImageVerifyCode;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 系统认证的API接口
 *
 * @author xuepeng
 */
@RestController
@RequestMapping("/v1/auth")
@Slf4j
@Validated
public class SysAuthController extends BaseController {

    /**
     * @return 生成图片验证码
     */
    @GetMapping("/v1/login-vc")
    @OperateLog(module = "系统管理", func = "身份认证", remark = "生成登录图片验证码",
            action = SysOperateLogAction.CREATE, persistent = false)
    @IPLimit
    public Result<ImageVerifyCode> createLoginImageVerifyCode() {
        final ImageVerifyCode imageVerifyCode = imageVerifyCodeClient.generate(VerifyCodeType.IMAGE_LOGIN);
        return DefaultResultFactory.success("获取图片验证码", imageVerifyCode);
    }

    /**
     * 图片验证码的工具
     */
    @Resource
    private ImageVerifyCodeClient imageVerifyCodeClient;

}
