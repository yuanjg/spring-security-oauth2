package io.github.yuanjg.browser.session;

import org.springframework.security.web.session.InvalidSessionStrategy;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 过期失效策略
 *
 * @author yuanjg
 * @create 2019-10-06 15:59
 */

public class WelkinInvalidSessionStrategy extends AbstractSessionInvalidStrategy implements InvalidSessionStrategy {

    public WelkinInvalidSessionStrategy(String destinationUrl) {
        super(destinationUrl);
    }

    @Override
    public void onInvalidSessionDetected(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        onSessionInvalid(request, response);
    }

}

