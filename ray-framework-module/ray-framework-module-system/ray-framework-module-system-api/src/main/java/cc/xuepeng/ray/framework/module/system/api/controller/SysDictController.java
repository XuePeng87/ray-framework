package cc.xuepeng.ray.framework.module.system.api.controller;

import cc.xuepeng.ray.framework.core.web.controller.BaseController;
import cn.dev33.satoken.annotation.SaCheckLogin;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 系统字典的API接口
 *
 * @author xuepeng
 */
@RestController
@RequestMapping("/v1/dicts")
@Slf4j
@Validated
@SaCheckLogin
public class SysDictController extends BaseController {

    public
}
