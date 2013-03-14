package com.hqtc.biz.impl;

import com.hqtc.biz.CustomerBiz;
import com.hqtc.model.dao.*;
import com.hqtc.model.entity.*;
import com.hqtc.util.MyMD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
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
    @Autowired
    private CardDao cardDao;
    @Autowired
    private TorderDao torderDao;
    @Autowired
    private WeeknumDao weeknumDao;
    @Autowired
    private DessertDao dessertDao;
    @Autowired
    private OrderitemDao orderitemDao;
    @Autowired
    private RechargeDao rechargeDao;

    public void setCustomerDao(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    @Override
    public int register(Customer customer) {
        String password = customer.getPassword();
        String newPass = MyMD5.encryption(password);
        customer.setPassword(newPass);
        customerDao.save(customer);
        List list = customerDao.accSearch(customer);
        return ((Customer) list.get(0)).getId();
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
        String password = customer.getPassword();
        String newPass = MyMD5.encryption(password);
        customer.setPassword(newPass);
        List list = customerDao.accPassSearch(customer);
        if (list.size() > 0) {
            return (Customer) list.get(0);
        }
        return null;
    }

    @Override
    public void recharge(Card card, int money) {
        float oldMoney = card.getMoney();
        float newMoney = oldMoney + money;
        card.setMoney(newMoney);
        cardDao.update(card);
        Recharge recharge = new Recharge();
        recharge.setCustomerid(card.getCustomerid());
        recharge.setDate(new Date(new java.util.Date().getTime()));
        recharge.setMoney(money);
        rechargeDao.save(recharge);
    }

    @Override
    public void terminate(Customer customer) {
        customerDao.delete(customer);
    }

    @Override
    public void makeOrder(Torder torder) {
        torderDao.save(torder);
    }

    @Override
    public Card getCardByCustomerId(Customer customer) {
        return cardDao.findByCustomerId(customer.getId());
    }

    @Override
    public void activeCard(Card card) {
        card.setState(1);
        cardDao.update(card);
    }

    @Override
    public List findWeekDesserts(int shopid, int weekday) {
        Weeknum weeknum = new Weeknum();
        weeknum.setShopid(shopid);
        weeknum.setWeekday(weekday);
        return weeknumDao.getWeekNumByShopDay(weeknum);
    }

    @Override
    public Dessert getDessertByWeekNum(Weeknum weeknum) {
        int dessertid = weeknum.getDessertid();
        return dessertDao.findById(dessertid);
    }

    @Override
    public Dessert getDessertById(int dessertid) {
        return dessertDao.findById(dessertid);
    }

    @Override
    public Weeknum getWeeknumById(int id) {
        return weeknumDao.findById(id);
    }

    @Override
    public void updateWeeknum(Weeknum weeknum1) {
        weeknumDao.update(weeknum1);
    }

    @Override
    public void saveOrderitem(Orderitem orderitem) {
        orderitemDao.save(orderitem);
    }

    @Override
    public void updateCard(Card card) {
        cardDao.update(card);
    }

    @Override
    public void saveCard(Card card1) {
        cardDao.save(card1);
    }

    @Override
    public void update(Customer customer1) {
        customerDao.update(customer1);
    }

    @Override
    public List<Recharge> getRechargesByCustomer(Customer customer) {
        return rechargeDao.getRechargesByCustomer(customer);  //todo
    }

    @Override
    public List<Torder> getOrdersByCustomer(Customer customer) {
        return torderDao.getOrdersByCustomer(customer);
    }
}
