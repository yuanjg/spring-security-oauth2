package io.github.yuanjg.core.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 权限配置文件父类（注意这里不用lombok 会读取不到）
 * 这里会有很多权限配置子模块
 *
 * @author yuanjg
 * @create 2019-10-06 8:41
 */

@ConfigurationProperties(value = "welkin.auth", ignoreInvalidFields = true)
public class SecurityProperties {

    /**
     * 浏览器配置类
     */
    private BrowserProperties browser = new BrowserProperties();

    /**
     * 验证码配置类
     */
    private CaptchaProperties captcha = new CaptchaProperties();

    /**
     * 社交配置类
     */
    private SocialProperties social = new SocialProperties();

    public SocialProperties getSocial() {
        return social;
    }

    public void setSocial(SocialProperties social) {
        this.social = social;
    }

    public BrowserProperties getBrowser() {
        return browser;
    }

    public void setBrowser(BrowserProperties browser) {
        this.browser = browser;
    }

    public CaptchaProperties getCaptcha() {
        return captcha;
    }

    public void setCaptcha(CaptchaProperties captcha) {
        this.captcha = captcha;
    }
}
