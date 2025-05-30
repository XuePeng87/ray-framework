package cc.xuepeng.ray.framework.core.web.interceptor;

import cc.xuepeng.ray.framework.core.common.util.RandomUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.MDC;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Nonnull;

/**
 * 日志追踪拦截器
 * 拦截Http请求，通过MDC写入trackId，用于日志打印
 * 并在HttpHeader中写入trackId返回给调用者
 *
 * @author xuepeng
 */
@Slf4j
public class LogTrackInterceptor implements HandlerInterceptor {

    /**
     * MDC追踪Key
     */
    private static final String TRACE_ID = "traceId";

    /**
     * HttpHeader Key
     */
    private static final String HEADER_KEY = "X-Trace-Id";

    @Override
    public boolean preHandle(@Nonnull HttpServletRequest request,
                             @Nonnull HttpServletResponse response,
                             @Nonnull Object handler) {
        String traceId = request.getHeader(HEADER_KEY);
        if (StringUtils.isBlank(traceId)) {
            traceId = RandomUtil.getUUID();
        }
        MDC.put(TRACE_ID, traceId);
        response.addHeader(HEADER_KEY, traceId);
        if (log.isDebugEnabled()) {
            log.debug("生成日志的TraceId：{}，设置到请求头{}中", traceId, HEADER_KEY);
        }
        return true;
    }

    @Override
    public void postHandle(@Nonnull HttpServletRequest request,
                           @Nonnull HttpServletResponse response,
                           @Nonnull Object handler,
                           ModelAndView modelAndView) {
        MDC.remove(TRACE_ID);
    }

    @Override
    public void afterCompletion(@Nonnull HttpServletRequest request,
                                @Nonnull HttpServletResponse response,
                                @Nonnull Object handler,
                                Exception ex) {
        // nothing
    }

}
