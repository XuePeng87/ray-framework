package cc.xuepeng.ray.framework.module.common.log.service.impl;

import cc.xuepeng.ray.framework.module.common.log.converter.SysOperateLogDetailConverter;
import cc.xuepeng.ray.framework.module.common.log.domain.dto.SysOperateLogDetailDto;
import cc.xuepeng.ray.framework.module.common.log.domain.entity.SysOperateLogDetail;
import cc.xuepeng.ray.framework.module.common.log.repository.SysOperateLogDetailRepository;
import cc.xuepeng.ray.framework.module.common.log.service.SysOperateLogDetailService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

/**
 * 系统操作日志详情的业务处理类
 *
 * @author xuepeng
 */
@Component
public class SysOperateLogDetailServiceImpl
        extends ServiceImpl<SysOperateLogDetailRepository, SysOperateLogDetail>
        implements SysOperateLogDetailService {

    /**
     * 创建系统操作日志详情
     *
     * @param sysOperateLogDetailDto 系统操作日志详情的数据传输对象
     */
    @Override
    public void create(final SysOperateLogDetailDto sysOperateLogDetailDto) {
        final SysOperateLogDetail sysOperateLogDetail =
                sysOperateLogDetailConverter.dtoToEntity(sysOperateLogDetailDto);
        super.save(sysOperateLogDetail);
    }

    /**
     * 系统操作日志详情对象转换接口
     */
    @Resource
    private SysOperateLogDetailConverter sysOperateLogDetailConverter;


}
