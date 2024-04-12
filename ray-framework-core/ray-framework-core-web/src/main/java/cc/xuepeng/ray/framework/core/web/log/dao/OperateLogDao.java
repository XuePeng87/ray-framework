package cc.xuepeng.ray.framework.core.web.log.dao;

import cc.xuepeng.ray.framework.core.web.log.model.OperateLogInfo;

/**
 * 操作日志的持久化接口
 *
 * @author xuepeng
 */
public interface OperateLogDao {

    /**
     * 持久化保存操作访问日志
     *
     * @param operateLogInfo 操作日志对象
     */
    void saveAccessLog(final OperateLogInfo operateLogInfo);

    /**
     * 持久化保存操作错误日志
     *
     * @param operateLogInfo 操作日志对象
     */
    void saveErrorLog(final OperateLogInfo operateLogInfo);

}
