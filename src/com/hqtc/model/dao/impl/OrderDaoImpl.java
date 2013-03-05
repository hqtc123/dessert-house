package com.hqtc.model.dao.impl;

import com.hqtc.model.dao.BaseDao;
import com.hqtc.model.dao.OrderDao;
import com.hqtc.model.dao.OrderitemDao;
import com.hqtc.model.entity.Order;
import com.hqtc.model.entity.Orderitem;

/**
 * Created with IntelliJ IDEA.
 * User: hqtc
 * Date: 13-3-5
 * Time: 下午8:23
 * To change this template use File | Settings | File Templates.
 */
public class OrderDaoImpl extends BaseDao implements OrderDao {

    @Override
    public void add(Order order) {
        super.add(order);
    }

    @Override
    public void delete(Order order) {
        super.delete(order);
    }

    @Override
    public void update(Order order) {
        super.update(order);
    }
}
