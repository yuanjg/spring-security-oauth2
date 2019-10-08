package io.github.yuanjg.core.authentication;

import io.github.yuanjg.core.support.SecurityConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

/**
 * 密码登录的通用安全配置
 * @author yuanjg
 * @create 2019-10-06 13:50
 */

public class AbstractChannelSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private AuthenticationSuccessHandler tigerAuthenticationSuccessHandler;
    @Autowired
    private AuthenticationFailureHandler tigerAuthenticationFailureHandler;

    /**
     * 密码登录配置
     * @param http
     * @throws Exception
     */
    protected void 	applyPasswordAuthenticationConfig(HttpSecurity http) throws Exception {
        http.formLogin()
                .loginPage(SecurityConstants.DEFAULT_UNAUTHENTICATION_URL)
                .loginProcessingUrl(SecurityConstants.DEFAULT_LOGIN_PROCESSING_URL_FORM)
                .successHandler(tigerAuthenticationSuccessHandler)
                .failureHandler(tigerAuthenticationFailureHandler);
    }


}
