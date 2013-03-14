package com.hqtc.model.dao;

import com.hqtc.model.entity.Customer;
import com.hqtc.model.entity.Torder;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: hqtc
 * Date: 13-3-5
 * Time: 下午8:18
 * To change this template use File | Settings | File Templates.
 */
public interface TorderDao extends BaseDao<Torder> {

    public List<Torder> findByShopId(int i);

    public List<Torder> getOrdersByCustomer(Customer customer);
}
