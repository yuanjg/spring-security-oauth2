package io.github.yuanjg.core.support.strategy;

/**
 * @author yuanjg
 * @create 2019-10-06 10:43
 */
public interface IStrategyContainer<C, S extends IStrategy<C>> {
    /**
     * 获得处理策略
     *
     * @param condition 策略条件
     * @return 对应策略条件的策略
     */
    S getStrategy(final C condition);
}
