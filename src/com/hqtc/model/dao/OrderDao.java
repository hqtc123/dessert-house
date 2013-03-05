package com.hqtc.model.dao;

import com.hqtc.model.entity.Order;

/**
 * Created with IntelliJ IDEA.
 * User: hqtc
 * Date: 13-3-5
 * Time: 下午8:18
 * To change this template use File | Settings | File Templates.
 */
public interface OrderDao {
    public void add(Order order);

    public void delete(Order order);

    public void update(Order order);
}
