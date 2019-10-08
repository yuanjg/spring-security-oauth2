package io.github.yuanjg.core.support.strategy;

/**
 * @author yuanjg
 * @create 2019-10-06 10:43
 */
public interface IStrategy<C> {

    /**
     * 获得策略条件
     *
     * @param
     * @return 用来注册的策略处理条件
     */
    C getCondition();
}
