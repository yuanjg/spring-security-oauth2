package io.github.yuanjg.core.authentication;

import com.alibaba.fastjson.JSON;
import io.github.yuanjg.core.properties.SecurityProperties;
import io.github.yuanjg.core.support.SimpleResponse;
import org.apache.commons.lang.StringUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 退出登录处理Handler
 *
 * @author yuanjg
 * @create 2019-10-06 16:35
 */
public class WelkinLogoutSuccessHandler implements LogoutSuccessHandler {


    private SecurityProperties securityProperties;

    public WelkinLogoutSuccessHandler(SecurityProperties securityProperties) {
        this.securityProperties = securityProperties;
    }

    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        String loginOutUrl = securityProperties.getBrowser().getLoginOut();

        if (StringUtils.isBlank(loginOutUrl)) {
            response.setContentType("application/json;charset=UTF-8");
            response.getWriter().write(JSON.toJSONString(new SimpleResponse("退出成功")));
        } else {
            response.sendRedirect(loginOutUrl);
        }
    }
}

