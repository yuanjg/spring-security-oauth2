package io.github.yuanjg.core.captcha;


import io.github.yuanjg.core.captcha.entity.CaptchaTypeEnum;
import io.github.yuanjg.core.captcha.exception.CaptchaException;
import io.github.yuanjg.core.captcha.processor.CaptchaProcessor;
import io.github.yuanjg.core.support.strategy.StrategyContainerImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 验证码处理器持有者 根据枚举类型查找验证码处理器
 *
 * @author yuanjg
 * @create 2019-10-06 12:41
 */

@Component
@Slf4j
public class CaptchaProcessorHolder {

    /**
     * 获取CaptchaProcessor接口实现类
     *
     * @param name
     * @return
     */
    CaptchaProcessor findCaptchaProcessor(String name) {
        CaptchaTypeEnum captchaTypeEnum = CaptchaTypeEnum.forCode(name);
        if (captchaTypeEnum == null) {
            log.error("验证码类型枚举" + name + "不存在");
            throw new CaptchaException("验证码类型枚举类" + name + "不存在");
        }
        return findCaptchaProcessor(captchaTypeEnum);
    }

    /**
     * 获取CaptchaProcessor 接口实现类
     *
     * @param captchaTypeEnum
     * @return
     */
    CaptchaProcessor findCaptchaProcessor(CaptchaTypeEnum captchaTypeEnum) {
        if (captchaTypeEnum == null) {
            throw new CaptchaException("验证码类型枚举类不存在");
        }
        CaptchaProcessor captchaProcessor = StrategyContainerImpl.getStrategy(CaptchaProcessor.class, captchaTypeEnum);
        if (captchaProcessor == null) {
            log.error("{}处理器不存在", captchaTypeEnum.getDesc());
            throw new CaptchaException(captchaTypeEnum.getDesc() + "处理器不存在");
        }
        log.info("{}处理器获取", captchaTypeEnum.getDesc());

        return captchaProcessor;
    }

}
