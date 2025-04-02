package cc.xuepeng.ray.framework.module.common.log.controller;

import cc.xuepeng.ray.framework.core.common.domain.response.PageResponse;
import cc.xuepeng.ray.framework.core.common.domain.result.DefaultResultFactory;
import cc.xuepeng.ray.framework.core.common.domain.result.Result;
import cc.xuepeng.ray.framework.core.web.controller.BaseController;
import cc.xuepeng.ray.framework.module.common.log.annotation.OperateLog;
import cc.xuepeng.ray.framework.module.common.log.converter.SysAuthLogDtoConverter;
import cc.xuepeng.ray.framework.module.common.log.domain.dto.SysAuthLogDto;
import cc.xuepeng.ray.framework.module.common.log.domain.request.SysAuthLogRequest;
import cc.xuepeng.ray.framework.module.common.log.domain.response.SysAuthLogResponse;
import cc.xuepeng.ray.framework.module.common.log.enums.SysOperateLogAction;
import cc.xuepeng.ray.framework.module.common.log.service.SysAuthLogService;
import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaCheckRole;
import cn.dev33.satoken.annotation.SaMode;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 系统认证日志的API接口
 *
 * @author xuepeng
 */
@RestController
@RequestMapping("/v1/auth-logs")
@Slf4j
@Validated
@SaCheckLogin
public class SysAuthLogController extends BaseController {

    /**
     * 分页查询系统认证日志
     *
     * @param sysAuthLogRequest 系统认证日志的请求对象
     * @return 系统认证日志的响应对象集合
     */
    @GetMapping("/v1/page")
    @OperateLog(module = "系统管理", func = "认证日志管理", remark = "分页查询认证日志",
            action = SysOperateLogAction.QUERY, persistent = false)
    @SaCheckRole(value = {"ROLE_SUPER_ADMIN", "ROLE_SYSTEM_ADMIN"}, mode = SaMode.OR)
    public Result<PageResponse<SysAuthLogResponse>> pageByCondition(final SysAuthLogRequest sysAuthLogRequest) {
        final SysAuthLogDto sysAuthLogDto = sysAuthLogDtoConverter.requestToDto(sysAuthLogRequest);
        final Page<SysAuthLogDto> result = sysAuthLogService.pageByCondition(sysAuthLogDto);
        return DefaultResultFactory.success("分页查询认证日志列表",
                sysAuthLogDtoConverter.dtoPageToResponsePage(result));
    }

    /**
     * 系统登录登出日志数据传输类转换接口
     */
    @Resource
    private SysAuthLogDtoConverter sysAuthLogDtoConverter;

    /**
     * 系统登录登出日志的服务处理接口
     */
    @Resource
    private SysAuthLogService sysAuthLogService;

}