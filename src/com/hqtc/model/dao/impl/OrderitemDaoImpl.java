package com.hqtc.model.dao.impl;

import com.hqtc.model.dao.OrderitemDao;
import com.hqtc.model.entity.Dessert;
import com.hqtc.model.entity.Orderitem;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: hqtc
 * Date: 13-3-5
 * Time: 下午8:07
 * To change this template use File | Settings | File Templates.
 */
@Repository
public class OrderitemDaoImpl extends BaseDaoImpl<Orderitem> implements OrderitemDao {

    @Override
    public int getNumofDessert(Dessert dessert) {
        if (dessert == null) {
            return 0;
        }
        int dessertid = dessert.getId();
        String sql = "SELECT SUM(num) FROM orderitem WHERE dessertid =" + dessertid + "";
        Session session = getSession();

        List list = session.createSQLQuery(sql).list();
        if (list == null || list.isEmpty()||list.get(0)==null) {
            return 0;
        }
        Object oo=list.get(0);
        BigDecimal bd = (BigDecimal)list.get(0);
        return bd.intValue();
    }
}
