package io.github.yuanjg.core.captcha.service;

import org.springframework.web.context.request.ServletWebRequest;


/**
 * 验证码生成接口
 *
 * @author yuanjg
 * @create 2019-10-06 9:35
 */
public interface CaptchaCreateService {
    /**
     * 生成验证码
     *
     * @param request
     * @param type
     */
    void createCaptcha(ServletWebRequest request, String type);
}
