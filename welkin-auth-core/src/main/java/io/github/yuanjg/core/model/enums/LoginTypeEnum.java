package io.github.yuanjg.core.model.enums;

import lombok.Getter;

/**
 * 登录类型枚举类
 *
 * @author yuanjg
 * @create 2019-10-06 8:41
 */
@Getter
public enum LoginTypeEnum {

    /**
     * json数据返回
     */
    JSON,
    /**
     * 重定向
     */
    REDIRECT;
}