package io.github.yuanjg.core.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;
import javax.servlet.Filter;

/**
 * 验证码过滤器配置
 * @author yuanjg
 * @create 2019-10-06 12:59
 */

@Component("captchaSecurityConfig")
public class CaptchaSecurityConfig extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {
    /**
     * 重构的验证码拦截器 （图片验证+短信验证）
     */
    @Autowired
    private Filter captchaFilter;

    /**
     * 验证码验证放在密码登录之前
     * @param http
     * @throws Exception
     */
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.addFilterBefore(captchaFilter, UsernamePasswordAuthenticationFilter.class);
    }
}