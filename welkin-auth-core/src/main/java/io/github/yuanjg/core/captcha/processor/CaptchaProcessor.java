package io.github.yuanjg.core.captcha.processor;

import io.github.yuanjg.core.captcha.entity.CaptchaTypeEnum;
import io.github.yuanjg.core.captcha.exception.CaptchaException;
import io.github.yuanjg.core.support.strategy.IStrategy;
import org.springframework.web.context.request.ServletWebRequest;

/**
 * 验证码处理器接口
 * @author yuanjg
 * @create 2019-10-06 10:39
 */

public interface CaptchaProcessor extends IStrategy<CaptchaTypeEnum> {
    /**
     * 验证码
     */
    public static String CAPTCHA_SESSION_KEY="captcha_session_key_";
    /**
     * 创建验证码
     * @param request 封装请求和响应
     * @throws Exception
     */
    void create(ServletWebRequest request) throws  Exception;

    /**
     * 校验验证码
     * @param servletWebRequest
     * @param captchaTypeEnum
     */
    void  validate(ServletWebRequest servletWebRequest, CaptchaTypeEnum captchaTypeEnum) throws CaptchaException;
}

