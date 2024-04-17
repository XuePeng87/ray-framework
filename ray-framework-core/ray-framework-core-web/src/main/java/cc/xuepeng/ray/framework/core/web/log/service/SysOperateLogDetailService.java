package cc.xuepeng.ray.framework.core.web.log.service;

import cc.xuepeng.ray.framework.core.web.log.domain.dto.SysOperateLogDetailDto;

public interface SysOperateLogDetailService {

    /**
     * 创建系统操作日志详情
     *
     * @param sysOperateLogDetailDto 系统操作日志详情的数据传输对象
     */
    void create(final SysOperateLogDetailDto sysOperateLogDetailDto);

}
