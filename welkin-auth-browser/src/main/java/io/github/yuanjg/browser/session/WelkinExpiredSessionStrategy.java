package io.github.yuanjg.browser.session;

import org.springframework.security.web.session.SessionInformationExpiredEvent;
import org.springframework.security.web.session.SessionInformationExpiredStrategy;

import javax.servlet.ServletException;
import java.io.IOException;

/**
 * 并发失效策略
 *
 * @author yuanjg
 * @create 2019-10-06 15:58
 */

public class WelkinExpiredSessionStrategy extends AbstractSessionInvalidStrategy implements SessionInformationExpiredStrategy {

    public WelkinExpiredSessionStrategy(String destinationUrl) {
        super(destinationUrl);
    }

    @Override
    public void onExpiredSessionDetected(SessionInformationExpiredEvent event) throws IOException, ServletException {
        onSessionInvalid(event.getRequest(), event.getResponse());
    }

    /**
     * 并发导致的失效
     *
     * @return
     */
    @Override
    protected boolean isConcurrency() {
        return true;
    }
}

