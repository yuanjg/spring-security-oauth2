package io.github.yuanjg.core.captcha.sms;

/**
 * 短信验证码发送接口
 *
 * @author yuanjg
 * @create 2019-10-06 10:19
 */
public interface SmsCaptchaSend {
    /**
     * 发送短信验证码
     *
     * @param mobile
     * @param code
     * @return
     */
    boolean sendSms(String mobile, String code);
}
