package cc.xuepeng.ray.framework.app.config;

import cc.xuepeng.ray.framework.core.web.log.interceptor.LogTrackInterceptor;
import cc.xuepeng.ray.framework.core.web.security.cors.CorsProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Collections;

/**
 * Web应用配置类
 * 1、配置请求参数的枚举转换器、日志转换器，处理Url参数中的数据；
 * 2、配置请求体的枚举转换器，处理Ajax的Body中的数据；
 *
 * @author xuepeng
 */
@Configuration
public class WebConfiguration implements WebMvcConfigurer {

    /**
     * 设置跨域过滤器
     *
     * @return 跨域过滤器
     */
    @Bean
    @Profile("!prod")
    public CorsFilter corsFilter() {
        final CorsConfiguration corsConfig = new CorsConfiguration();
        final CorsProperty corsProperty = new CorsProperty();
        corsConfig.setAllowedOriginPatterns(Collections.singletonList(corsProperty.getOrigins()));
        corsConfig.addAllowedHeader(corsProperty.getHeaders());
        corsConfig.addAllowedMethod(corsProperty.getMethods());
        corsConfig.setAllowCredentials(corsProperty.isCredentials());
        corsConfig.setMaxAge(corsProperty.getAge());
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration(corsProperty.getMapping(), corsConfig);
        return new CorsFilter(source);
    }

    /**
     * 注册日志拦截器
     * 对所有API(/**)生效
     *
     * @param registry 拦截器注册表
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LogTrackInterceptor()).addPathPatterns("/**");
    }

}
