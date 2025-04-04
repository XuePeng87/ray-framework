package cc.xuepeng.ray.framework.sdk.auth.annotation;

import java.lang.annotation.*;

/**
 * 设置创建人
 *
 * @author xuepeng
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface CreateUser {
}
