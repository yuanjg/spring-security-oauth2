package io.github.yuanjg.core.properties;

import io.github.yuanjg.core.support.SecurityConstants;

/**
 * @author yuanjg
 * @create 2019-10-06 8:41
 */
public class SessionProperties {

    //session最大并发数
    private int maximumSessions = 1;

    //默认false 会踢掉之前已经登录的信息
    private boolean maxSessionsPreventsLogin;

    //默认失效界面
    private String invalidSessionUrl = SecurityConstants.DEFAULT_SESSION_INVALID_URL;


    public int getMaximumSessions() {
        return maximumSessions;
    }

    public void setMaximumSessions(int maximumSessions) {
        this.maximumSessions = maximumSessions;
    }

    public boolean isMaxSessionsPreventsLogin() {
        return maxSessionsPreventsLogin;
    }

    public void setMaxSessionsPreventsLogin(boolean maxSessionsPreventsLogin) {
        this.maxSessionsPreventsLogin = maxSessionsPreventsLogin;
    }

    public String getInvalidSessionUrl() {
        return invalidSessionUrl;
    }

    public void setInvalidSessionUrl(String invalidSessionUrl) {
        this.invalidSessionUrl = invalidSessionUrl;
    }
}
