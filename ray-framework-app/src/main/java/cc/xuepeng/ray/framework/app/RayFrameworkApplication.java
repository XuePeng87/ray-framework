package cc.xuepeng.ray.framework.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Ray Framework启动类
 *
 * @author xuepeng
 */
@SpringBootApplication
@ComponentScan("cc.xuepeng.ray.framework.*")
public class RayFrameworkApplication {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(RayFrameworkApplication.class);
        application.setAllowCircularReferences(Boolean.TRUE);
        application.run(args);
    }

}