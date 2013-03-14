package com.hqtc.biz;

import com.hqtc.model.entity.*;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: hqtc
 * Date: 13-3-7
 * Time: 下午3:42
 * To change this template use File | Settings | File Templates.
 */
public interface ManagerBiz extends MemberBiz {
    public List<Customer> viewCustomers();

    public List<Card> viewCards();

    public List<Orderitem> viewSales();

    public Card getCardByCutomer(Customer customer);

    public List<Torder> viewOrdersByShopId(int i);

    public int getNumofDessert(Dessert dessert);
}
