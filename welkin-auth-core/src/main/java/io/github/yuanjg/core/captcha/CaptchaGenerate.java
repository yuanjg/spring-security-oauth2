package io.github.yuanjg.core.captcha;


import io.github.yuanjg.core.captcha.entity.CaptchaVo;

/**
 * 验证码生成接口
 * @author yuanjg
 * @create 2019-10-06 9:35
 */
public interface CaptchaGenerate {
    /**
     * 生成图片验证码
     *
     * @return
     */
    CaptchaVo generate();
}
