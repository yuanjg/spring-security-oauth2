package io.github.yuanjg.core.properties;

/**
 * 微信配置文件
 *
 * @author yuanjg
 * @create 2019-10-07 8:36
 */


public class WechatProperties {

    /**
     * 第三方id，用来决定发起第三方登录的url，默认是 weixin。
     */
    private String providerId = "wechat";

    private String appId;//应用id

    private String appSecret;//应用密匙

    public String getProviderId() {
        return providerId;
    }

    public void setProviderId(String providerId) {
        this.providerId = providerId;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getAppSecret() {
        return appSecret;
    }

    public void setAppSecret(String appSecret) {
        this.appSecret = appSecret;
    }
}
