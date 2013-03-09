package com.hqtc.biz.impl;

import com.hqtc.biz.ManagerBiz;
import com.hqtc.model.entity.Card;
import com.hqtc.model.entity.Customer;
import com.hqtc.model.entity.Orderitem;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: hqtc
 * Date: 13-3-7
 * Time: 下午4:14
 * To change this template use File | Settings | File Templates.
 */
@Service
public class ManagerBizImpl extends MemberBizImpl implements ManagerBiz {
    @Override
    public ArrayList<Customer> viewCustomers() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public ArrayList<Card> viewCards() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public ArrayList<Orderitem> viewSales() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
