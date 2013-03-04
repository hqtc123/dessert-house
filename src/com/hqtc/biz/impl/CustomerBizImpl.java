package com.hqtc.biz.impl;

import com.hqtc.biz.CustomerBiz;
import com.hqtc.dao.CustomerDao;
import com.hqtc.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: He Qing
 * Date: 13-2-5
 * Time: 下午4:45
 * To change this template use File | Settings | File Templates.
 */
@Service
public class CustomerBizImpl implements CustomerBiz {
    @Autowired
    private CustomerDao customerDao;

    public void setCustomerDao(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    @Override
    public void register(Customer customer) {
        customerDao.add(customer);
    }

    @Override
    public boolean checkAccExist(Customer customer) {
        boolean exist = false;
        List list = customerDao.accSearch(customer);
        if (list.size() > 0) {
            exist = true;
        }
        return exist;
    }

    @Override
    public Customer getCustomerByAccPass(Customer customer) {
        List list = customerDao.accPassSearch(customer);
        if (list.size() > 0) {
            return (Customer) list.get(0);
        }
        return null;
    }
}
