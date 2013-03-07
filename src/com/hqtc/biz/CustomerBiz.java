package com.hqtc.biz;

import com.hqtc.model.entity.Customer;
import com.hqtc.model.entity.Order;

/**
 * Created with IntelliJ IDEA.
 * User: He Qing
 * Date: 13-2-5
 * Time: 下午4:41
 * To change this template use File | Settings | File Templates.
 */
public interface CustomerBiz {
    public void register(Customer customer);

    public boolean checkAccExist(Customer customer);

    public Customer getCustomerByAccPass(Customer customer);

    public void recharge(Customer customer,int money);

    public void terminate(Customer customer);

    public void makeOrder(Order order);

    public void cancelOrder(Order order);
}
