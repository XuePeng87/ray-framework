package cc.xuepeng.ray.framework.core.redis.property;

import lombok.*;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@ConfigurationProperties(prefix = "ray.framework.core.redis")
public class RedisProperty {

    /**
     * 是否开启Redis事务，默认关闭
     */
    private Boolean transaction = Boolean.FALSE;

}
