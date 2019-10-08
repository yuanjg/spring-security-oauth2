package io.github.yuanjg.core.captcha;

import io.github.yuanjg.core.captcha.service.CaptchaCreateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 验证码控制器
 *
 * @author yuanjg
 * @create 2019-10-06 9:35
 */
@Slf4j
@RestController
public class CaptchaController {

    @Autowired
    private CaptchaCreateService captchaCreateService;
    /**
     * 获取验证码
     *
     * @param request
     * @param response
     * @throws IOException
     */
    @GetMapping("/captcha/{type}")
    public void createCaptcha(HttpServletRequest request, HttpServletResponse response, @PathVariable String type) throws Exception {
        log.info("获取验证码开始");
        captchaCreateService.createCaptcha(new ServletWebRequest(request, response), type);
        log.info("获取验证码结束");
    }


}

