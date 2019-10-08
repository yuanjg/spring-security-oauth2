package io.github.yuanjg.core.properties;

/**
 * 社交配置
 *
 * @author yuanjg
 * @create 2019-10-06 17:48
 */

public class SocialProperties {
    private QQProperties qq = new QQProperties();

    private WechatProperties wechat = new WechatProperties();

    private String filterProcessesUrl = "/auth";

    public String getFilterProcessesUrl() {
        return filterProcessesUrl;
    }

    public void setFilterProcessesUrl(String filterProcessesUrl) {
        this.filterProcessesUrl = filterProcessesUrl;
    }

    public QQProperties getQq() {
        return qq;
    }

    public void setQq(QQProperties qq) {
        this.qq = qq;
    }

    public WechatProperties getWechat() {
        return wechat;
    }

    public void setWechat(WechatProperties wechat) {
        this.wechat = wechat;
    }
}
