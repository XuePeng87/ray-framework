package cc.xuepeng.ray.framework.module.system.api.controller;

import cc.xuepeng.ray.framework.core.model.param.ParamValidateScope;
import cc.xuepeng.ray.framework.core.model.result.DefaultResultFactory;
import cc.xuepeng.ray.framework.core.model.result.Result;
import cc.xuepeng.ray.framework.core.web.controller.BaseController;
import cc.xuepeng.ray.framework.core.web.log.annotation.OperateLog;
import cc.xuepeng.ray.framework.core.web.log.enums.SysOperateLogAction;
import cc.xuepeng.ray.framework.module.system.api.facade.SysFuncFacade;
import cc.xuepeng.ray.framework.module.system.domain.param.SysFuncParam;
import cc.xuepeng.ray.framework.module.system.domain.vo.SysFuncVo;
import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaCheckRole;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 系统功能的API接口
 *
 * @author xuepeng
 */
@RestController
@RequestMapping("/v1/funcs")
@Slf4j
@Validated
@SaCheckLogin
public class SysFuncController extends BaseController {

    /**
     * 创建系统功能
     *
     * @param sysFuncParam 系统功能的请求对象
     * @return 是否创建成功
     */
    @PostMapping("/v1")
    @SaCheckRole("ROLE_SUPER_ADMIN")
    @OperateLog(module = "系统管理", func = "功能管理", remark = "创建功能", action = SysOperateLogAction.CREATE)
    public Result<Boolean> create(
            @Validated(ParamValidateScope.create.class) @RequestBody final SysFuncParam sysFuncParam
    ) {
        return sysFuncFacade.create(sysFuncParam) ?
                DefaultResultFactory.success("创建系统功能成功", Boolean.TRUE) :
                DefaultResultFactory.fail("创建系统功能失败", Boolean.FALSE);
    }

    /**
     * 修改系统功能
     *
     * @param code         系统功能的编号
     * @param sysFuncParam 系统功能的请求对象
     * @return 是否修改成功
     */
    @PutMapping("/v1/{code}")
    @SaCheckRole("ROLE_SUPER_ADMIN")
    @OperateLog(module = "系统管理", func = "功能管理", remark = "修改功能", action = SysOperateLogAction.UPDATE)
    public Result<Boolean> update(
            @PathVariable(value = "code") final String code,
            @Validated(ParamValidateScope.update.class) @RequestBody final SysFuncParam sysFuncParam
    ) {
        return sysFuncFacade.update(code, sysFuncParam) ?
                DefaultResultFactory.success("修改系统功能成功", Boolean.TRUE) :
                DefaultResultFactory.fail("修改系统功能失败", Boolean.FALSE);
    }

    /**
     * 删除系统功能
     *
     * @param code 系统功能的编号
     * @return 是否删除成功
     */
    @DeleteMapping("/v1/{code}")
    @SaCheckRole("ROLE_SUPER_ADMIN")
    @OperateLog(module = "系统管理", func = "功能管理", remark = "删除功能", action = SysOperateLogAction.DELETE)
    public Result<Boolean> delete(@PathVariable(value = "code") final String code) {
        return sysFuncFacade.delete(code) ?
                DefaultResultFactory.success("删除系统功能成功", Boolean.TRUE) :
                DefaultResultFactory.fail("删除系统功能失败", Boolean.FALSE);
    }

    /**
     * 根据编号查询系统功能
     *
     * @param code 系统功能的编号
     * @return 系统功能的响应对象
     */
    @GetMapping("/v1/{code}")
    @SaCheckRole("ROLE_SUPER_ADMIN")
    @OperateLog(module = "系统管理", func = "功能管理", remark = "查询功能",
            action = SysOperateLogAction.DETAIL, persistent = false)
    public Result<SysFuncVo> findByCode(@PathVariable(value = "code") final String code) {
        final SysFuncVo sysFuncVo = sysFuncFacade.findByCode(code);
        return DefaultResultFactory.success("查询系统功能成功", sysFuncVo);
    }

    /**
     * 根据条件查询系统功能
     *
     * @param sysFuncParam 系统功能的请求对象
     * @return 系统功能的响应对象集合
     */
    @GetMapping("/v1")
    @OperateLog(module = "系统管理", func = "功能管理", remark = "查询功能树",
            action = SysOperateLogAction.QUERY, persistent = false)
    @SaCheckRole("ROLE_SUPER_ADMIN")
    public Result<List<SysFuncVo>> treeByCondition(
            @Validated(ParamValidateScope.page.class) final SysFuncParam sysFuncParam
    ) {
        final List<SysFuncVo> result = sysFuncFacade.treeByCondition(sysFuncParam);
        return DefaultResultFactory.success("查询系统功能", result);
    }

    /**
     * 系统功能的门面接口
     */
    @Resource
    private SysFuncFacade sysFuncFacade;

}
