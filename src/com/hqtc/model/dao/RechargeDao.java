package com.hqtc.model.dao;

import com.hqtc.model.entity.Customer;
import com.hqtc.model.entity.Recharge;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: hqtc
 * Date: 13-3-7
 * Time: 下午4:38
 * To change this template use File | Settings | File Templates.
 */
public interface RechargeDao extends BaseDao<Recharge>{
    public List<Recharge> getRechargesByCustomer(Customer customer);
}
