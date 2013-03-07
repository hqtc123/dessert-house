package com.hqtc.model.dao;

import com.hqtc.model.entity.Strategy;

/**
 * Created with IntelliJ IDEA.
 * User: hqtc
 * Date: 13-3-7
 * Time: 下午4:36
 * To change this template use File | Settings | File Templates.
 */
public interface StrategyDao {
    public void add(Strategy strategy);

    public void delete(Strategy strategy);

    public void update(Strategy strategy);
}
