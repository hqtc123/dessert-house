package com.hqtc.model.dao.impl;

import com.hqtc.model.dao.TorderDao;
import com.hqtc.model.entity.Torder;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: hqtc
 * Date: 13-3-5
 * Time: 下午8:23
 * To change this template use File | Settings | File Templates.
 */
@Repository
public class TorderDaoImpl extends BaseDaoImpl<Torder> implements TorderDao {
    @Override
    public List<Torder> findByShopId(int i) {
        List list = null;
        Session session = getSession();
        Criteria criteria = session.createCriteria(Torder.class);
        criteria.add(Restrictions.eq("shopid", i));
        list = criteria.list();
        return list;
    }
}
