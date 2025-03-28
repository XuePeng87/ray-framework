package cc.xuepeng.ray.framework.module.common.log.repository;

import cc.xuepeng.ray.framework.module.common.log.domain.entity.SysAuthLog;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * 系统登录登出日志的数据库访问接口
 *
 * @author xuepeng
 */
public interface SysAuthLogRepository extends BaseMapper<SysAuthLog> {
}
