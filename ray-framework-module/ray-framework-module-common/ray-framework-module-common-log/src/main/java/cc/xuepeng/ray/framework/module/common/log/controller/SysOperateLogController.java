package cc.xuepeng.ray.framework.module.common.log.controller;

import cc.xuepeng.ray.framework.core.common.domain.response.PageResponse;
import cc.xuepeng.ray.framework.core.common.domain.result.DefaultResultFactory;
import cc.xuepeng.ray.framework.core.common.domain.result.Result;
import cc.xuepeng.ray.framework.core.web.controller.BaseController;
import cc.xuepeng.ray.framework.module.common.log.annotation.OperateLog;
import cc.xuepeng.ray.framework.module.common.log.converter.SysOperateLogDtoConverter;
import cc.xuepeng.ray.framework.module.common.log.domain.dto.SysOperateLogDto;
import cc.xuepeng.ray.framework.module.common.log.domain.request.SysOperateLogRequest;
import cc.xuepeng.ray.framework.module.common.log.domain.response.SysOperateLogResponse;
import cc.xuepeng.ray.framework.module.common.log.enums.SysOperateLogAction;
import cc.xuepeng.ray.framework.module.common.log.service.SysOperateLogService;
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
 * 系统操作日志的API接口
 *
 * @author xuepeng
 */
@RestController
@RequestMapping("/v1/operate-logs")
@Slf4j
@Validated
@SaCheckLogin
public class SysOperateLogController extends BaseController {

    /**
     * 分页查询系统操作日志
     *
     * @param sysOperateLogRequest 系统操作日志的请求对象
     * @return 系统操作日志的响应对象集合
     */
    @GetMapping("/v1/page")
    @OperateLog(module = "系统管理", func = "操作日志管理", remark = "分页查询操作日志",
            action = SysOperateLogAction.QUERY, persistent = false)
    @SaCheckRole(value = {"ROLE_SUPER_ADMIN", "ROLE_SYSTEM_ADMIN"}, mode = SaMode.OR)
    public Result<PageResponse<SysOperateLogResponse>> pageByCondition(final SysOperateLogRequest sysOperateLogRequest) {
        final SysOperateLogDto sysOperateLogDto = sysOperateLogDtoConverter.requestToDto(sysOperateLogRequest);
        final Page<SysOperateLogDto> result = sysOperateLogService.pageByCondition(sysOperateLogDto);
        return DefaultResultFactory.success("分页查询操作日志列表",
                sysOperateLogDtoConverter.dtoPageToResponsePage(result));
    }

    /**
     * 系统操作日志数据传输类转换接口
     */
    @Resource
    private SysOperateLogDtoConverter sysOperateLogDtoConverter;

    /**
     * 系统操作日志的服务处理接口
     */
    @Resource
    private SysOperateLogService sysOperateLogService;

}