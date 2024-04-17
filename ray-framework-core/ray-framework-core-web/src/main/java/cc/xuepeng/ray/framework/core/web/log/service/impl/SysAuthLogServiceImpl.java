package cc.xuepeng.ray.framework.core.web.log.service.impl;

import cc.xuepeng.ray.framework.core.mybatis.util.PageUtil;
import cc.xuepeng.ray.framework.core.mybatis.util.QueryWrapperUtil;
import cc.xuepeng.ray.framework.core.web.log.converter.SysAuthLogConverter;
import cc.xuepeng.ray.framework.core.web.log.dao.SysAuthLogDao;
import cc.xuepeng.ray.framework.core.web.log.domain.dto.SysAuthLogDto;
import cc.xuepeng.ray.framework.core.web.log.domain.entity.SysAuthLog;
import cc.xuepeng.ray.framework.core.web.log.service.SysAuthLogService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import jakarta.annotation.Resource;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

/**
 * 系统登录登出的业务处理类
 *
 * @author xuepeng
 */
@Component
public class SysAuthLogServiceImpl
        extends ServiceImpl<SysAuthLogDao, SysAuthLog>
        implements SysAuthLogService {

    /**
     * 创建系统登录登出日志
     *
     * @param sysAuthLogDto 系统登录登出日志的数据传输对象
     */
    @Override
    public void create(final SysAuthLogDto sysAuthLogDto) {
        final SysAuthLog sysAuthLog = sysAuthLogConverter.dtoToEntity(sysAuthLogDto);
        super.save(sysAuthLog);
    }

    /**
     * 分页查询系统登录登出日志
     *
     * @param sysAuthLogDto 系统登录登出日志的数据传输对象
     * @return 系统登录登出日志分页数据
     */
    @Override
    public Page<SysAuthLogDto> pageByCondition(final SysAuthLogDto sysAuthLogDto) {
        final SysAuthLog sysAuthLog = this.sysAuthLogConverter.dtoToEntity(sysAuthLogDto);
        final QueryWrapper<SysAuthLog> wrapper = QueryWrapperUtil.createQueryWrapper();
        final LambdaQueryWrapper<SysAuthLog> lambda = wrapper.lambda();
        lambda.eq(ObjectUtils.isNotEmpty(sysAuthLog.getType()), SysAuthLog::getType, sysAuthLog.getType());
        lambda.eq(StringUtils.isNotBlank(sysAuthLog.getCreateUser()), SysAuthLog::getCreateUser, sysAuthLog.getCreateUser());
        lambda.eq(StringUtils.isNotBlank(sysAuthLog.getLoginIp()), SysAuthLog::getLoginIp, sysAuthLog.getLoginIp());
        if (ObjectUtils.isNotEmpty(sysAuthLogDto.getBeginCreateTime())
                && ObjectUtils.isNotEmpty(sysAuthLogDto.getEndCreateTime())) {
            lambda.between(SysAuthLog::getCreateTime,
                    sysAuthLogDto.getBeginCreateTime(),
                    sysAuthLogDto.getEndCreateTime());
        }
        lambda.orderByDesc(SysAuthLog::getCreateTime);
        final Page<SysAuthLog> page = PageUtil.createPage(sysAuthLogDto);
        final Page<SysAuthLog> logs = super.page(page, wrapper);
        return this.sysAuthLogConverter.entityPageToDtoPage(logs);
    }

    /**
     * 系统登录登出对象转换接口
     */
    @Resource
    private SysAuthLogConverter sysAuthLogConverter;

}
