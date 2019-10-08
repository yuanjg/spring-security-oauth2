package io.github.yuanjg.core.captcha.entity;

import lombok.Data;

import java.awt.image.BufferedImage;
import java.time.LocalDateTime;

/**
 * 图片验证码信息对象
 * @author yuanjg
 * @create 2019-10-06 9:34
 */

@Data
public class ImageCaptchaVo extends CaptchaVo {
    /**
     * 图片验证码
     */
    private BufferedImage image;

    public ImageCaptchaVo(BufferedImage image, String code, int expireAfterSeconds) {
        super(code, expireAfterSeconds);
        this.image = image;
    }

    public ImageCaptchaVo(BufferedImage image, String code, LocalDateTime expireTime) {
        super(code, expireTime);
        this.image = image;
    }

}
