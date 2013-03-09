package com.hqtc.model.dao;

import com.hqtc.model.entity.Strategy;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: hqtc
 * Date: 13-3-7
 * Time: 下午4:36
 * To change this template use File | Settings | File Templates.
 */
public interface StrategyDao extends BaseDao<Strategy> {
    public List getAll();

    public List getStrategyByScore(Strategy strategy);
}
