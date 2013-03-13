package com.hqtc.biz.impl;

import com.hqtc.biz.ManagerBiz;
import com.hqtc.model.dao.CardDao;
import com.hqtc.model.dao.CustomerDao;
import com.hqtc.model.dao.OrderitemDao;
import com.hqtc.model.dao.TorderDao;
import com.hqtc.model.entity.Card;
import com.hqtc.model.entity.Customer;
import com.hqtc.model.entity.Orderitem;
import com.hqtc.model.entity.Torder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: hqtc
 * Date: 13-3-7
 * Time: 下午4:14
 * To change this template use File | Settings | File Templates.
 */
@Service
public class ManagerBizImpl extends MemberBizImpl implements ManagerBiz {
    @Autowired
    private CustomerDao customerDao;
    @Autowired
    private CardDao cardDao;
    @Autowired
    private OrderitemDao orderitemDao;
    @Autowired
    private TorderDao torderDao;

    @Override
    public List<Customer> viewCustomers() {
        return customerDao.getAll();
    }

    @Override
    public List<Card> viewCards() {
        return cardDao.getAll();
    }

    @Override
    public List<Orderitem> viewSales() {
        return orderitemDao.getAll();
    }

    @Override
    public Card getCardByCutomer(Customer customer) {
        int customerId = customer.getId();
        return cardDao.findByCustomerId(customerId);
    }

    @Override
    public List<Torder> viewOrdersByShopId(int i) {
        return torderDao.findByShopId(i);
    }

}
