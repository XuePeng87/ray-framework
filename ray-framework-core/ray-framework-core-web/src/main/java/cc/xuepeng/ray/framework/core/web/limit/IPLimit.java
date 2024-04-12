package cc.xuepeng.ray.framework.core.web.limit;

import java.lang.annotation.*;

/**
 * IP限流注解
 *
 * @author xuepeng
 */
@Inherited
@Documented
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface IPLimit {

}
