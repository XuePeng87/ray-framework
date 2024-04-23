package cc.xuepeng.ray.framework.core.web.limit;

import cc.xuepeng.ray.framework.core.web.util.WebUtil;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.util.concurrent.RateLimiter;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * IP限流注解的实现类
 *
 * @author xuepeng
 */
@Component
@Scope
@Aspect
@Slf4j
public class IPLimitService {

    /**
     * IP限流缓存
     */
    private final LoadingCache<String, RateLimiter> ipRequestCaches = CacheBuilder.newBuilder()
            .maximumSize(1024)// 设置缓存个数
            .expireAfterWrite(1, TimeUnit.DAYS)
            .build(new CacheLoader<String, RateLimiter>() {
                @Override
                public RateLimiter load(String s) {
                    if (log.isDebugEnabled()) {
                        log.debug("创建IP限流缓存，IP地址为：{}", s);
                    }
                    // 新的IP初始化 (限流每秒10个令牌响应)
                    return RateLimiter.create(10);
                }
            });

    /**
     * IP限流注解的切点
     */
    @Pointcut("@annotation(cc.xuepeng.ray.framework.core.web.limit.IPLimit)")
    public void ipLimit() {
        // IP限流
    }

    /**
     * IP限流注解的实现
     *
     * @throws ExecutionException 限流失败抛出ExecutionException
     */
    @Before("ipLimit()")
    public void beforeIPLimit() throws ExecutionException {
        final String ip = WebUtil.getIPAddress(request);
        final RateLimiter limiter = ipRequestCaches.get(ip);
        if (!limiter.tryAcquire()) {
            log.warn("IP {} 请求过于频繁", ip);
            throw new IPLimitException(ip + "请求过于频繁，请稍后在试");
        }
    }

    /**
     * HttpRequest对象
     */
    @Resource
    private HttpServletRequest request;

}
