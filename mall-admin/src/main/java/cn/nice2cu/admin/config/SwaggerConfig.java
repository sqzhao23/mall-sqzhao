package cn.nice2cu.admin.config;

import cn.nice2cu.common.config.BaseSwaggerConfig;
import cn.nice2cu.common.domain.SwaggerProperties;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * SwaggerConfig 配置类
 * @author sqzhao
 * @date 2021年05月16日 10:55
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig extends BaseSwaggerConfig {

    @Override
    public SwaggerProperties swaggerProperties() {
        return SwaggerProperties.builder()
            .apiBasePackage("cn.nice2cu.admin.controller")
            .title("mall-sqzhao后台系统")
            .description("mall-sqzhao后台相关接口文档")
            .contactName("sqzhao")
            .version("1.0")
            .enableSecurity(true)
            .build();
    }
}
