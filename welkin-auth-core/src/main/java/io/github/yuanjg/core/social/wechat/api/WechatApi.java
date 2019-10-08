package io.github.yuanjg.core.social.wechat.api;

/**
 * 微信用户api接口
 *
 * @author yuanjg
 * @create 2019-10-07 8:26
 */

public interface WechatApi {
    /**
     * 获取微信用户信息
     *
     * @param openId
     * @return
     */
    WechatUserInfo getUserInfo(String openId);
}
