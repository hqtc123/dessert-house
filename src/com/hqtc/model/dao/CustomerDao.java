package com.hqtc.model.dao;

import com.hqtc.model.entity.Customer;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: He Qing
 * Date: 13-2-5
 * Time: 下午12:58
 * To change this template use File | Settings | File Templates.
 */
public interface CustomerDao extends BaseDao<Customer> {
    public List accSearch(Customer customer);

    public List accPassSearch(Customer customer);

    public List getAll();
}
