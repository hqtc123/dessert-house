package com.hqtc.biz;

import com.hqtc.model.entity.Card;
import com.hqtc.model.entity.Customer;
import com.hqtc.model.entity.Orderitem;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: hqtc
 * Date: 13-3-7
 * Time: 下午3:42
 * To change this template use File | Settings | File Templates.
 */
public interface ManagerBiz {
    public ArrayList<Customer> viewCustomers();
    public ArrayList<Card> viewCards();
    public ArrayList<Orderitem> viewSales();
}
