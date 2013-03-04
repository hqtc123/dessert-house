package com.hqtc.dao.impl;

import com.hqtc.dao.BaseDao;
import com.hqtc.dao.CustomerDao;
import com.hqtc.model.Customer;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: He Qing
 * Date: 13-2-5
 * Time: 下午2:02
 * To change this template use File | Settings | File Templates.
 */
@Repository
public class CustomerDaoImpl extends BaseDao implements CustomerDao {

    @Override
    public void add(Customer customer) {
        super.add(customer);    //To change body of overridden methods use File | Settings | File Templates.
    }

    @Override
    public void delete(Customer customer) {
        super.delete(customer);
    }

    @Override
    public void update(Customer customer) {
        super.update(customer);
    }

    @Override
    public List accPassSearch(Customer customer) {
        List list = null;
        Session session = getSession();
        Criteria criteria = session.createCriteria(Customer.class);
        try {
            if (customer != null) {
                criteria.add(Restrictions.like("account", customer.getAccount(), MatchMode.EXACT));
                criteria.add(Restrictions.like("password", customer.getPassword(), MatchMode.EXACT));
                list = criteria.list();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List accSearch(Customer customer) {
        List list = null;
        Session session = getSession();
        Criteria criteria = session.createCriteria(Customer.class);
        try {
            if (customer != null) {
                criteria.add(Restrictions.like("account", customer.getAccount(), MatchMode.EXACT));
                list = criteria.list();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
