package com.hqtc.biz;

import com.hqtc.model.entity.*;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: He Qing
 * Date: 13-2-5
 * Time: 下午4:41
 * To change this template use File | Settings | File Templates.
 */
public interface CustomerBiz {
    public int register(Customer customer);

    public boolean checkAccExist(Customer customer);

    public Customer getCustomerByAccPass(Customer customer);

    public void recharge(Card card, int money);

    public void terminate(Customer customer);

    public void makeOrder(Torder torder);

    public Card getCardByCustomerId(Customer customer);

    public void activeCard(Card card);

    public List findWeekDesserts(int shopid, int weekday);

    public Dessert getDessertByWeekNum(Weeknum weeknum);

    public Dessert getDessertById(int dessertid);

    public Weeknum getWeeknumById(int id);

    public void updateWeeknum(Weeknum weeknum1);

    public void saveOrderitem(Orderitem orderitem);

    public void updateCard(Card card);

    public void saveCard(Card card1);

    public void update(Customer customer1);
}
