package io.github.yuanjg.core.captcha.processor;

import io.github.yuanjg.core.captcha.entity.CaptchaTypeEnum;
import io.github.yuanjg.core.captcha.entity.CaptchaVo;
import io.github.yuanjg.core.captcha.exception.CaptchaException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.social.connect.web.HttpSessionSessionStrategy;
import org.springframework.social.connect.web.SessionStrategy;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.context.request.ServletWebRequest;

import java.io.IOException;

/**
 * 验证码处理器抽象父类
 *
 * @author yuanjg
 * @create 2019-10-06 10:42
 */
@Slf4j
public abstract class AbstractCaptchaProcessor<C extends CaptchaVo> implements CaptchaProcessor {

    //@Autowired
    //private CaptchaRepository captchaRepository;

    private SessionStrategy sessionStrategy = new HttpSessionSessionStrategy();

    /**
     * 创建验证码
     *
     * @param request 封装请求和响应
     * @throws Exception
     */
    @Override
    public void create(ServletWebRequest request) throws Exception {
        //生成
        C captcha = generateCaptcha(request);
        //保存
        save(request, captcha);
        //发送
        send(request, captcha);
    }

    /**
     * 短信和手机验证码的通用验证
     *
     * @param request
     * @param captchaType 验证码
     */
    @Override
    public void validate(ServletWebRequest request, CaptchaTypeEnum captchaType) throws CaptchaException {
        CaptchaVo captchaInSession = (CaptchaVo) sessionStrategy.getAttribute(request, captchaType.getParamNameOnValidate());
        //CaptchaVo captchaInSession = (CaptchaVo) captchaRepository.get(request, captchaType);
        String captchaInRequest;
        try {
            captchaInRequest = ServletRequestUtils.getStringParameter(request.getRequest(),
                    captchaType.getParamNameOnValidate());
        } catch (ServletRequestBindingException e) {
            throw new CaptchaException("获取验证码的值失败");
        }

        if (StringUtils.isBlank(captchaInRequest)) {
            throw new CaptchaException(captchaType + "验证码的值不能为空");
        }

        if (captchaInSession == null) {
            throw new CaptchaException(captchaType + "验证码不存在");
        }

        if (captchaInSession.isExpried()) {
            sessionStrategy.removeAttribute(request, captchaType.getParamNameOnValidate());
            //captchaRepository.remove(request, captchaType);
            throw new CaptchaException(captchaType + "验证码已过期");
        }

        if (!StringUtils.equals(captchaInSession.getCode(), captchaInRequest)) {
            throw new CaptchaException(captchaType + "");
        }
        //验证成功清除缓存中的key
        sessionStrategy.removeAttribute(request, captchaType.getParamNameOnValidate());
        //captchaRepository.remove(request, captchaType);
        log.info("校验【{}】", captchaType.getDesc());
    }

    protected abstract C generateCaptcha(ServletWebRequest request);

    protected abstract void send(ServletWebRequest request, C captcha) throws IOException, ServletRequestBindingException;

    private void save(ServletWebRequest request, C captcha) {
        //redis不支持bufferImage序列化
        CaptchaVo captchaVo = new CaptchaVo(captcha.getCode(), captcha.getExpireTime());
        sessionStrategy.setAttribute(request, getCondition().getParamNameOnValidate(), captchaVo);
        //captchaRepository.save(request, captchaVo, getCondition());
    }

    /**
     * 根据请求的url获取校验码的类型
     *
     * @param request
     * @return
     */
    private String getCaptchaTypeFromUrl(ServletWebRequest request) {
        return StringUtils.substringAfter(request.getRequest().getRequestURI(), "/captcha/");
    }


}
