package cc.xuepeng.ray.framework.core.web.log.dao;

import cc.xuepeng.ray.framework.core.web.log.model.AuthLogInfo;

/**
 * 鉴权日志的持久化接口
 *
 * @author xuepeng
 */
public interface AuthLogDao {

    /**
     * 持久化保存鉴权日志
     *
     * @param authLogInfo 鉴权日志对象
     */
    void saveLoginLog(final AuthLogInfo authLogInfo);

}
