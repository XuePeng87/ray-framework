package cc.xuepeng.ray.framework.module.system.api.controller;

import cc.xuepeng.ray.framework.core.model.param.ParamValidateScope;
import cc.xuepeng.ray.framework.core.model.result.DefaultResultFactory;
import cc.xuepeng.ray.framework.core.model.result.Result;
import cc.xuepeng.ray.framework.core.model.vo.PageVo;
import cc.xuepeng.ray.framework.core.web.controller.BaseController;
import cc.xuepeng.ray.framework.core.web.log.annotation.OperateLog;
import cc.xuepeng.ray.framework.core.web.log.enums.SysOperateLogAction;
import cc.xuepeng.ray.framework.module.system.api.facade.SysRoleFacade;
import cc.xuepeng.ray.framework.module.system.domain.param.SysRoleParam;
import cc.xuepeng.ray.framework.module.system.domain.vo.SysRoleVo;
import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaCheckRole;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 系统角色的API接口
 *
 * @author xuepeng
 */
@RestController
@RequestMapping("/v1/roles")
@Slf4j
@Validated
@SaCheckLogin
public class SysRoleController extends BaseController {

    /**
     * 创建系统角色
     *
     * @param sysRoleParam 系统角色的请求对象
     * @return 是否创建成功
     */
    @PostMapping("/v1")
    @SaCheckRole("ROLE_SUPER_ADMIN")
    @OperateLog(module = "系统管理", func = "角色管理", remark = "创建角色", action = SysOperateLogAction.CREATE)
    public Result<Boolean> create(
            @Validated(ParamValidateScope.create.class) @RequestBody final SysRoleParam sysRoleParam
    ) {
        return sysRoleFacade.create(sysRoleParam) ?
                DefaultResultFactory.success("创建系统角色成功", Boolean.TRUE) :
                DefaultResultFactory.fail("创建系统角色失败", Boolean.FALSE);
    }

    /**
     * 修改系统角色
     *
     * @param code         系统角色的编号
     * @param sysRoleParam 系统角色的请求对象
     * @return 是否修改成功
     */
    @PutMapping("/v1/{code}")
    @SaCheckRole("ROLE_SUPER_ADMIN")
    @OperateLog(module = "系统管理", func = "角色管理", remark = "修改角色", action = SysOperateLogAction.UPDATE)
    public Result<Boolean> update(
            @PathVariable(value = "code") final String code,
            @Validated(ParamValidateScope.create.class) @RequestBody final SysRoleParam sysRoleParam
    ) {
        return sysRoleFacade.update(code, sysRoleParam) ?
                DefaultResultFactory.success("修改系统角色成功", Boolean.TRUE) :
                DefaultResultFactory.fail("修改系统角色失败", Boolean.FALSE);
    }

    /**
     * 删除系统角色
     *
     * @param code 系统角色的编号
     * @return 是否删除成功
     */
    @DeleteMapping("/v1/{code}")
    @SaCheckRole("ROLE_SUPER_ADMIN")
    @OperateLog(module = "系统管理", func = "角色管理", remark = "删除角色", action = SysOperateLogAction.DELETE)
    public Result<Boolean> delete(@PathVariable(value = "code") final String code) {
        return sysRoleFacade.delete(code) ?
                DefaultResultFactory.success("删除系统角色成功", Boolean.TRUE) :
                DefaultResultFactory.fail("删除系统角色失败", Boolean.FALSE);
    }

    /**
     * 根据编号查询系统角色
     *
     * @param code 系统角色的编号
     * @return 系统角色的响应对象
     */
    @GetMapping("/v1/{code}")
    @SaCheckRole("ROLE_SUPER_ADMIN")
    @OperateLog(module = "系统管理", func = "角色管理", remark = "查询角色",
            action = SysOperateLogAction.DETAIL, persistent = false)
    public Result<SysRoleVo> findByCode(@PathVariable(value = "code") final String code) {
        final SysRoleVo result = sysRoleFacade.findByCode(code);
        return DefaultResultFactory.success("查询系统角色", result);
    }

    /**
     * 分页查询系统角色
     *
     * @param sysRoleParam 系统角色的请求对象
     * @return 系统角色的响应对象集合
     */
    @GetMapping("/v1/page")
    @SaCheckRole("ROLE_SUPER_ADMIN")
    @OperateLog(module = "系统管理", func = "角色管理", remark = "分页查询角色",
            action = SysOperateLogAction.QUERY, persistent = false)
    public Result<PageVo<SysRoleVo>> pageByCondition(final SysRoleParam sysRoleParam) {
        final PageVo<SysRoleVo> result = sysRoleFacade.pageByCondition(sysRoleParam);
        return DefaultResultFactory.success("分页查询角色列表", result);
    }

    /**
     * 授权系统功能到系统角色
     *
     * @param code      系统角色的编号
     * @param funcCodes 系统功能的编号集合
     */
    @PostMapping("/v1/{code}/grant-func")
    @SaCheckRole("ROLE_SUPER_ADMIN")
    @OperateLog(module = "系统管理", func = "角色管理", remark = "保存授权功能", action = SysOperateLogAction.GRANT)
    public Result<Boolean> grantFunc(@PathVariable(value = "code") final String code,
                                     @RequestBody final List<String> funcCodes) {
        sysRoleFacade.saveFuncToRole(code, funcCodes);
        return DefaultResultFactory.success("授权功能成功", Boolean.TRUE);
    }

    /**
     * 查询系统角色所授权的系统功能
     *
     * @param code 系统角色的编号
     * @return 系统功能的编号集合
     */
    @GetMapping("/v1/{code}/grant-func")
    @SaCheckRole("ROLE_SUPER_ADMIN")
    @OperateLog(module = "系统管理", func = "角色管理", remark = "查询授权功能",
            action = SysOperateLogAction.GRANT, persistent = false)
    public Result<List<String>> findFunc(@PathVariable(value = "code") final String code) {
        return DefaultResultFactory.success("查询授权功能",
                sysRoleFacade.findFuncCodesByCode(code));
    }

    /**
     * 系统角色的业务处理门面接口
     */
    @Resource
    private SysRoleFacade sysRoleFacade;

}
