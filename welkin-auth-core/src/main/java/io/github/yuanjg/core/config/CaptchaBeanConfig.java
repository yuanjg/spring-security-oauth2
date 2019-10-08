package io.github.yuanjg.core.config;

import io.github.yuanjg.core.captcha.CaptchaGenerate;
import io.github.yuanjg.core.captcha.image.ImageCaptchaGenerate;
import io.github.yuanjg.core.captcha.sms.DefaultSmsCaptchaSender;
import io.github.yuanjg.core.captcha.sms.SmsCaptchaGenerate;
import io.github.yuanjg.core.captcha.sms.SmsCaptchaSend;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 验证码Bean生成配置类
 *
 * @author yuanjg
 * @create 2019-10-06 10:24
 */

@Configuration
public class CaptchaBeanConfig {

    //图片验证码生成
    @Bean
    @ConditionalOnMissingBean(name = "imageCaptchaGenerate")
    public CaptchaGenerate imageCaptchaGenerate() {
        ImageCaptchaGenerate imageCaptchaGenerate = new ImageCaptchaGenerate();
        return imageCaptchaGenerate;
    }

    //短信验证码生成
    @Bean
    @ConditionalOnMissingBean(name = "smsCaptchaGenerate")
    public CaptchaGenerate smsCaptchaGenerate() {
        SmsCaptchaGenerate smsCaptchaGenerate = new SmsCaptchaGenerate();
        return smsCaptchaGenerate;
    }

    //短信发送实现类
    @Bean
    @ConditionalOnMissingBean(DefaultSmsCaptchaSender.class)
    public SmsCaptchaSend defaultSmsCaptchaSender() {
        DefaultSmsCaptchaSender defaultSmsCaptchaSender = new DefaultSmsCaptchaSender();
        return defaultSmsCaptchaSender;
    }

}
