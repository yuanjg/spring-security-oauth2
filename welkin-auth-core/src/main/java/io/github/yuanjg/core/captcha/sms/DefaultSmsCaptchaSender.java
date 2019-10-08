package io.github.yuanjg.core.captcha.sms;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 短信验证码发送实现类
 * @author yuanjg
 * @create 2019-10-06 10:23
 */

@Slf4j
@Service
public class DefaultSmsCaptchaSender implements SmsCaptchaSend {

    //实际生产环境中,调用渠道供应商发送短信
    @Override
    public boolean sendSms(String mobile, String code) {
        log.info("模拟向手机{}发送短信验证码{}",mobile,code);
        log.info("短信渠道发送中...发送成功");
        return true;
    }

}
