package io.github.yuanjg.core.properties;

/**
 * 验证码配置类
 *
 * @author yuanjg
 * @create 2019-10-06 10:15
 */


public class CaptchaProperties {
    /**
     * 图片验证码配置
     */
    private ImageCaptchaProperties image = new ImageCaptchaProperties();
    /**
     * 短信验证码配置
     */
    private SmsCaptchaProperties sms = new SmsCaptchaProperties();

    public ImageCaptchaProperties getImage() {
        return image;
    }

    public void setImage(ImageCaptchaProperties image) {
        this.image = image;
    }

    public SmsCaptchaProperties getSms() {
        return sms;
    }

    public void setSms(SmsCaptchaProperties sms) {
        this.sms = sms;
    }
}

