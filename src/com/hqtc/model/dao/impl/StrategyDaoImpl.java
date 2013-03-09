package com.hqtc.model.dao.impl;

import com.hqtc.model.dao.StrategyDao;
import com.hqtc.model.entity.Strategy;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: hqtc
 * Date: 13-3-7
 * Time: 下午4:41
 * To change this template use File | Settings | File Templates.
 */
@Repository
public class StrategyDaoImpl extends BaseDaoImpl<Strategy> implements StrategyDao {

    @Override
    public List getStrategyByScore(Strategy strategy) {
        List list = null;
        Session session = getSession();
        Criteria criteria = session.createCriteria(Strategy.class);
        try {
            if (strategy != null) {
                criteria.add(Restrictions.eq("score", strategy.getScore()));
                list = criteria.list();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
