package cc.xuepeng.ray.framework.module.system.api.controller;

import cc.xuepeng.ray.framework.core.model.param.ParamValidateScope;
import cc.xuepeng.ray.framework.core.model.result.DefaultResultFactory;
import cc.xuepeng.ray.framework.core.model.result.Result;
import cc.xuepeng.ray.framework.core.model.vo.PageVo;
import cc.xuepeng.ray.framework.core.web.controller.BaseController;
import cc.xuepeng.ray.framework.core.web.log.annotation.OperateLog;
import cc.xuepeng.ray.framework.core.web.log.enums.SysOperateLogAction;
import cc.xuepeng.ray.framework.module.system.api.facade.SysDictItemFacade;
import cc.xuepeng.ray.framework.module.system.domain.param.SysDictItemParam;
import cc.xuepeng.ray.framework.module.system.domain.vo.SysDictItemVo;
import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaCheckRole;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 系统字典项的API接口
 *
 * @author xuepeng
 */
@RestController
@RequestMapping("/v1/dict-items")
@Slf4j
@Validated
@SaCheckLogin
public class SysDictItemController extends BaseController {

    /**
     * 创建系统字典项
     *
     * @param sysDictItemParam 系统字典项的请求对象
     * @return 是否创建成功
     */
    @PostMapping("/v1")
    @SaCheckRole("ROLE_SUPER_ADMIN")
    @OperateLog(module = "系统管理", func = "字典管理", remark = "创建字典项", action = SysOperateLogAction.CREATE)
    public Result<Boolean> create(
            @Validated(ParamValidateScope.create.class) @RequestBody final SysDictItemParam sysDictItemParam) {
        return sysDictItemFacade.create(sysDictItemParam) ?
                DefaultResultFactory.success("创建系统字典项成功", Boolean.TRUE) :
                DefaultResultFactory.error("创建系统字典项失败", Boolean.FALSE);
    }

    /**
     * 修改系统字典项
     *
     * @param code             系统字典项的编号
     * @param sysDictItemParam 系统字典项的请求对象
     * @return 是否修改成功
     */
    @PutMapping("/v1/{code}")
    @SaCheckRole("ROLE_SUPER_ADMIN")
    @OperateLog(module = "系统管理", func = "字典管理", remark = "修改字典项", action = SysOperateLogAction.UPDATE)
    public Result<Boolean> update(
            @PathVariable(value = "code") final String code,
            @Validated(ParamValidateScope.create.class) @RequestBody final SysDictItemParam sysDictItemParam
    ) {
        return sysDictItemFacade.update(code, sysDictItemParam) ?
                DefaultResultFactory.success("修改系统字典项成功", Boolean.TRUE) :
                DefaultResultFactory.error("修改系统字典项失败", Boolean.FALSE);
    }

    /**
     * 删除系统字典项
     *
     * @param codes 系统字典项的编号集合
     * @return 是否删除成功
     */
    @DeleteMapping("/v1")
    @SaCheckRole("ROLE_SUPER_ADMIN")
    @OperateLog(module = "系统管理", func = "字典管理", remark = "删除字典项", action = SysOperateLogAction.DELETE)
    public Result<Boolean> delete(@RequestBody final List<String> codes) {
        return sysDictItemFacade.delete(codes) ?
                DefaultResultFactory.success("删除系统字典项成功", Boolean.TRUE) :
                DefaultResultFactory.error("删除系统字典项失败", Boolean.FALSE);
    }

    /**
     * 根据编号查询系统字典项
     *
     * @param code 系统字典项的编号
     * @return 系统字典项的响应对象
     */
    @GetMapping("/v1/{code}")
    @SaCheckRole("ROLE_SUPER_ADMIN")
    @OperateLog(module = "系统管理", func = "字典管理", remark = "查询字典项",
            action = SysOperateLogAction.DETAIL, persistent = false)
    public Result<SysDictItemVo> findByCode(@PathVariable(value = "code") final String code) {
        final SysDictItemVo result = sysDictItemFacade.findByCode(code);
        return DefaultResultFactory.success("查询系统字典项", result);
    }

    /**
     * 分页查询系统字典项
     *
     * @param sysDictItemParam 系统字典项的请求对象
     * @return 系统字典项的响应对象集合
     */
    @GetMapping("/v1/page")
    @OperateLog(module = "系统管理", func = "字典管理", remark = "分页查询字典项",
            action = SysOperateLogAction.QUERY, persistent = false)
    @SaCheckRole("ROLE_SUPER_ADMIN")
    public Result<PageVo<SysDictItemVo>> pageByCondition(final SysDictItemParam sysDictItemParam) {
        final PageVo<SysDictItemVo> result = sysDictItemFacade.pageByCondition(sysDictItemParam);
        return DefaultResultFactory.success("分页查询字典列表", result);
    }

    /**
     * 系统字典项的业务处理门面接口
     */
    @Resource
    private SysDictItemFacade sysDictItemFacade;

}
