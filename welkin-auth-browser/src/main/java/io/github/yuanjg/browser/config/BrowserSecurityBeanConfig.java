package io.github.yuanjg.browser.config;

import io.github.yuanjg.core.authentication.WelkinLogoutSuccessHandler;
import io.github.yuanjg.browser.session.WelkinExpiredSessionStrategy;
import io.github.yuanjg.browser.session.WelkinInvalidSessionStrategy;
import io.github.yuanjg.core.properties.SecurityProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.session.InvalidSessionStrategy;
import org.springframework.security.web.session.SessionInformationExpiredStrategy;

/**
 * 失效默认实现
 * 自定义重写可以覆盖此实现
 *
 * @author yuanjg
 * @create 2019-10-06 16:00
 */


@Configuration
public class BrowserSecurityBeanConfig {
    @Autowired
    private SecurityProperties securityProperties;

    @Bean
    @ConditionalOnMissingBean(InvalidSessionStrategy.class)
    public InvalidSessionStrategy invalidSessionStrategy() {
        return new WelkinInvalidSessionStrategy(securityProperties.getBrowser().getSession().getInvalidSessionUrl());
    }

    @Bean
    @ConditionalOnMissingBean(SessionInformationExpiredStrategy.class)
    public SessionInformationExpiredStrategy sessionInformationExpiredStrategy() {
        return new WelkinExpiredSessionStrategy(securityProperties.getBrowser().getSession().getInvalidSessionUrl());
    }

    //退出
    @Bean
    @ConditionalOnMissingBean(LogoutSuccessHandler.class)
    public LogoutSuccessHandler tigerLogoutSuccessHandler(){
        return new WelkinLogoutSuccessHandler(securityProperties);
    }

}
