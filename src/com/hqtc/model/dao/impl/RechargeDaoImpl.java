package com.hqtc.model.dao.impl;

import com.hqtc.model.dao.RechargeDao;
import com.hqtc.model.entity.Customer;
import com.hqtc.model.entity.Recharge;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: hqtc
 * Date: 13-3-7
 * Time: 下午4:39
 * To change this template use File | Settings | File Templates.
 */
@Repository
public class RechargeDaoImpl extends BaseDaoImpl<Recharge> implements RechargeDao {
    @Override
    public List<Recharge> getRechargesByCustomer(Customer customer) {
        List list = null;
        Session session = getSession();
        try {
            if (customer != null) {
                Criteria criteria = session.createCriteria(Recharge.class);
                criteria.add(Restrictions.eq("customerid", customer.getId()));
                list = criteria.list();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
