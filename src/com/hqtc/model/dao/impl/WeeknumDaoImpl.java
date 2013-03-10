package com.hqtc.model.dao.impl;

import com.hqtc.model.dao.WeeknumDao;
import com.hqtc.model.entity.Weeknum;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: hqtc
 * Date: 13-3-5
 * Time: 下午8:22
 * To change this template use File | Settings | File Templates.
 */
@Repository
public class WeeknumDaoImpl extends BaseDaoImpl<Weeknum> implements WeeknumDao {
    @SuppressWarnings("unchecked")
    @Override
    public List getWeekNumByShopDay(Weeknum weeknum) {
        List list = null;
        Session session = getSession();
        Criteria criteria = session.createCriteria(Weeknum.class);
        try {
            if (weeknum != null) {
                criteria.add(Restrictions.eq("shopid", weeknum.getShopid()));
                criteria.add(Restrictions.eq("weekday", weeknum.getWeekday()));
                list = criteria.list();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
