package io.github.yuanjg.core.captcha.exception;

import org.springframework.security.core.AuthenticationException;

/**
 * 自定义验证码异常
 * @author yuanjg
 * @create 2019-10-06 9:41
 */

public class CaptchaException extends AuthenticationException {

    public CaptchaException(String msg, Throwable t) {
        super(msg, t);
    }

    public CaptchaException(String msg) {
        super(msg);
    }
}

