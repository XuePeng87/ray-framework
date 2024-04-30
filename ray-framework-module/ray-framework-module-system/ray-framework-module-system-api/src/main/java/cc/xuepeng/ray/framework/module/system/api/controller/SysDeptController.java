package cc.xuepeng.ray.framework.module.system.api.controller;

import cc.xuepeng.ray.framework.core.auth.annotation.CreateUser;
import cc.xuepeng.ray.framework.core.auth.annotation.ModifyUser;
import cc.xuepeng.ray.framework.core.model.param.ParamValidateScope;
import cc.xuepeng.ray.framework.core.model.result.DefaultResultFactory;
import cc.xuepeng.ray.framework.core.model.result.Result;
import cc.xuepeng.ray.framework.core.web.controller.BaseController;
import cc.xuepeng.ray.framework.core.web.log.annotation.OperateLog;
import cc.xuepeng.ray.framework.core.web.log.enums.SysOperateLogAction;
import cc.xuepeng.ray.framework.module.system.api.facade.SysDeptFacade;
import cc.xuepeng.ray.framework.module.system.domain.param.SysDeptParam;
import cc.xuepeng.ray.framework.module.system.domain.vo.SysDeptVo;
import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaCheckPermission;
import cn.dev33.satoken.annotation.SaCheckRole;
import cn.dev33.satoken.annotation.SaMode;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 系统部门的API接口
 *
 * @author xuepeng
 */
@RestController
@RequestMapping("/v1/depts")
@Slf4j
@Validated
@SaCheckLogin
public class SysDeptController extends BaseController {

    /**
     * 创建系统部门
     *
     * @param sysDeptParam 系统部门的请求对象
     * @return 系统部门的编号
     */
    @PostMapping("/v1")
    @CreateUser
    @SaCheckRole("ROLE_SUPER_ADMIN")
    @OperateLog(module = "系统管理", func = "部门管理", remark = "创建部门", action = SysOperateLogAction.CREATE)
    public Result<Boolean> create(
            @Validated(ParamValidateScope.create.class) @RequestBody final SysDeptParam sysDeptParam
    ) {
        return sysDeptFacade.create(sysDeptParam) ?
                DefaultResultFactory.success("创建部门成功", Boolean.TRUE) :
                DefaultResultFactory.fail("创建部门失败", Boolean.FALSE);
    }

    /**
     * 修改系统部门
     *
     * @param code         系统部门的编号
     * @param sysDeptParam 系统部门的请求对象
     * @return 是否修改成功
     */
    @PutMapping("/v1/{code}")
    @ModifyUser
    @SaCheckRole("ROLE_SUPER_ADMIN")
    @OperateLog(module = "系统管理", func = "部门管理", remark = "修改部门", action = SysOperateLogAction.UPDATE)
    public Result<Boolean> update(
            @PathVariable(value = "code") final String code,
            @Validated(ParamValidateScope.update.class) @RequestBody final SysDeptParam sysDeptParam
    ) {
        return sysDeptFacade.update(code, sysDeptParam) ?
                DefaultResultFactory.success("修改部门成功", Boolean.TRUE) :
                DefaultResultFactory.fail("修改部门失败", Boolean.FALSE);
    }

    /**
     * 删除系统部门
     *
     * @param code 系统部门的编号
     * @return 是否删除成功
     */
    @DeleteMapping("/v1/{code}")
    @ModifyUser
    @SaCheckRole("ROLE_SUPER_ADMIN")
    @OperateLog(module = "系统管理", func = "部门管理", remark = "删除部门", action = SysOperateLogAction.DELETE)
    public Result<Boolean> delete(@PathVariable(value = "code") final String code) {
        return sysDeptFacade.delete(code) ?
                DefaultResultFactory.success("删除系统部门成功", Boolean.TRUE) :
                DefaultResultFactory.fail("删除系统部门失败", Boolean.FALSE);
    }

    /**
     * 根据编号查询系统部门
     *
     * @param code 系统部门的编号
     * @return 系统部门的响应对象
     */
    @GetMapping("/v1/{code}")
    @SaCheckRole("ROLE_SUPER_ADMIN")
    @SaCheckPermission("ray:system:dept:find")
    @OperateLog(module = "系统管理", func = "部门管理", remark = "查询部门详情",
            action = SysOperateLogAction.DETAIL, persistent = false)
    public Result<SysDeptVo> findByCode(@PathVariable(value = "code") final String code) {
        final SysDeptVo result = sysDeptFacade.findByCode(code);
        return DefaultResultFactory.success("根据编号查询部门", result);
    }

    /**
     * 根据条件查询系统部门
     *
     * @param sysDeptParam 系统部门的请求对象
     * @return 系统部门的响应对象集合
     */
    @GetMapping("/v1")
    @OperateLog(module = "系统管理", func = "部门管理", remark = "查询部门树",
            action = SysOperateLogAction.QUERY, persistent = false)
    @SaCheckRole(value = {"ROLE_SUPER_ADMIN", "ROLE_SYSTEM_ADMIN", "ROLE_TENANT_ADMIN"}, mode = SaMode.OR)
    public Result<List<SysDeptVo>> treeByCondition(
            @Validated(ParamValidateScope.page.class) final SysDeptParam sysDeptParam
    ) {
        final List<SysDeptVo> result = sysDeptFacade.treeByCondition(sysDeptParam);
        return DefaultResultFactory.success("查询系统部门", result);
    }

    /**
     * 系统部门的门面接口
     */
    @Resource
    private SysDeptFacade sysDeptFacade;

}
