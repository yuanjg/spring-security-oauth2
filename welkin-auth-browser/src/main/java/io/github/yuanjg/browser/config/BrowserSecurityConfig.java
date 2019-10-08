package io.github.yuanjg.browser.config;

import io.github.yuanjg.core.authentication.AbstractChannelSecurityConfig;
import io.github.yuanjg.core.config.CaptchaSecurityConfig;
import io.github.yuanjg.core.config.SmsAuthenticationSecurityConfig;
import io.github.yuanjg.core.properties.SecurityProperties;
import io.github.yuanjg.core.support.SecurityConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.security.web.session.InvalidSessionStrategy;
import org.springframework.security.web.session.SessionInformationExpiredStrategy;
import org.springframework.social.security.SpringSocialConfigurer;

import javax.sql.DataSource;

/**
 * 浏览器security配置类
 *
 * @author yuanjg
 * @create 2019-10-06 8:29
 */
@Configuration
public class BrowserSecurityConfig extends AbstractChannelSecurityConfig {

    @Autowired
    private SecurityProperties securityProperties;
    @Autowired
    private DataSource dataSource;
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private CaptchaSecurityConfig captchaSecurityConfig;//验证码配置
    @Autowired
    private SmsAuthenticationSecurityConfig smsAuthenticationSecurityConfig;//短信登陆配置
    @Autowired
    private SessionInformationExpiredStrategy sessionInformationExpiredStrategy;//session失效策略
    @Autowired
    private InvalidSessionStrategy invalidSessionStrategy;//并发策略
    @Autowired
    private LogoutSuccessHandler welkinLogoutSuccessHandler;//退出管理
    @Autowired
    private SpringSocialConfigurer welkinSpringSocialConfigurer;

    /**
     * 记住我持久化数据源
     * JdbcTokenRepositoryImpl  CREATE_TABLE_SQL 建表语句可以先在数据库中执行
     *
     * @return
     */
    @Bean
    public PersistentTokenRepository persistentTokenRepository() {
        JdbcTokenRepositoryImpl jdbcTokenRepository = new JdbcTokenRepositoryImpl();
        jdbcTokenRepository.setDataSource(dataSource);
        //第一次会执行CREATE_TABLE_SQL建表语句 后续会报错 可以关掉
        //jdbcTokenRepository.setCreateTableOnStartup(true);
        return jdbcTokenRepository;
    }


    /**
     * 密码加密解密
     *
     * @return
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        /**
         * 表单密码配置
         */
        applyPasswordAuthenticationConfig(http);

        //将验证码的过滤器放在登陆的前面
        http.apply(captchaSecurityConfig)
                .and()
                .apply(smsAuthenticationSecurityConfig)
                .and()
                .apply(welkinSpringSocialConfigurer)
                //记住我相关配置
                .and()
                .rememberMe()
                .tokenRepository(persistentTokenRepository())
                .tokenValiditySeconds(securityProperties.getBrowser().getRemberMeSeconds())
                .userDetailsService(userDetailsService)
                //session管理
                .and()
                .sessionManagement()
                .invalidSessionStrategy(invalidSessionStrategy)
                .maximumSessions(securityProperties.getBrowser().getSession().getMaximumSessions())//最大session并发数
                .maxSessionsPreventsLogin(securityProperties.getBrowser().getSession().isMaxSessionsPreventsLogin())//true达到并发数后阻止登录，false 踢掉之前的登录
                .expiredSessionStrategy(sessionInformationExpiredStrategy)
                //退出管理
                .and()
                .and()
                .logout()
                .logoutUrl(securityProperties.getBrowser().getLoginOut()) //默认logout
                //.logoutSuccessUrl("") url和Handler只能配置一个
                .logoutSuccessHandler(welkinLogoutSuccessHandler)
                .deleteCookies("JSESSIONID")//清楚cook键值

                .and()
                .authorizeRequests()
                .antMatchers(
                        SecurityConstants.DEFAULT_UNAUTHENTICATION_URL,//权限认证
                        SecurityConstants.DEFAULT_LOGIN_PROCESSING_URL_MOBILE,//手机
                        securityProperties.getBrowser().getLoginPage(),//登录页面
                        SecurityConstants.DEFAULT_VALIDATE_CODE_URL_PREFIX + "/*", // /captcha/* 验证码放行
                        securityProperties.getBrowser().getSignupUrl()
                ).permitAll()//放行
                .anyRequest()
                .authenticated()
                .and()
                .csrf().disable();//跨域关闭


        //配置管理
        //defaultAuthorizeConfigManager.config(http.authorizeRequests());
    }

}

