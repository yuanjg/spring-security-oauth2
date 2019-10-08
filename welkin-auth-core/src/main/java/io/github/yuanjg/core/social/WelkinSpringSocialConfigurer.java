package io.github.yuanjg.core.social;

import org.springframework.social.security.SocialAuthenticationFilter;
import org.springframework.social.security.SpringSocialConfigurer;

/**
 * 自定义SpringSocialConfigurer 用于覆盖默认的社交登陆拦截请求
 *
 * @author yuanjg
 * @create 2019-10-06 19:48
 */

public class WelkinSpringSocialConfigurer extends SpringSocialConfigurer {

    private String filterProcessesUrl;//覆盖默认的/auth 拦截路径

    public WelkinSpringSocialConfigurer(String filterProcessesUrl) {
        this.filterProcessesUrl = filterProcessesUrl;
    }

    @Override
    protected <T> T postProcess(T object) {
        SocialAuthenticationFilter socialAuthenticationFilter = (SocialAuthenticationFilter) super.postProcess(object);
        socialAuthenticationFilter.setFilterProcessesUrl(filterProcessesUrl);
        return (T) socialAuthenticationFilter;
    }
}
