package io.github.yuanjg.core.captcha.sms;

import io.github.yuanjg.core.captcha.CaptchaGenerate;
import io.github.yuanjg.core.captcha.entity.CaptchaVo;
import io.github.yuanjg.core.properties.SecurityProperties;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 短信验证码生成器
 *
 * @author yuanjg
 * @create 2019-10-06 10:19
 */
@Service("smsCaptchaGenerate")
public class SmsCaptchaGenerate implements CaptchaGenerate {

    @Autowired
    private SecurityProperties securityProperties;

    /**
     * 生成短信验证码
     *
     * @return
     */
    @Override
    public CaptchaVo generate() {
        String code = RandomStringUtils.randomNumeric(securityProperties.getCaptcha().getSms().getLength());
        return new CaptchaVo(code, securityProperties.getCaptcha().getSms().getExpireSeconds());
    }
}
