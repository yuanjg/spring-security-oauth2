package io.github.yuanjg.core.config;

import io.github.yuanjg.core.properties.SecurityProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * SecurityProperties 配置类注入生效
 *
 * @author yuanjg
 * @create 2019-10-06 8:44
 */
@Configuration
@EnableConfigurationProperties(SecurityProperties.class)
public class SecurityPropertiesCoreConfig {
}
