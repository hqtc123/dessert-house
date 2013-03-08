package com.hqtc.biz.impl;

import com.hqtc.biz.CustomerBiz;
import com.hqtc.model.dao.CardDao;
import com.hqtc.model.dao.TorderDao;
import com.hqtc.model.entity.Card;
import com.hqtc.model.entity.Torder;
import com.hqtc.util.MyMD5;
import com.hqtc.model.dao.CustomerDao;
import com.hqtc.model.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public void setCustomerDao(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    @Override
    public void register(Customer customer) {
        String password = customer.getPassword();
        String newPass = MyMD5.encryption(password);
        customer.setPassword(newPass);
        customerDao.save(customer);
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
    public void recharge(Customer customer, int money) {
        Card card = customer.getCard();
        float oldMoney = card.getMoney();
        float newMoney = oldMoney + money;
        card.setMoney(newMoney);
        cardDao.update(card);
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
    public void cancelOrder(Torder torder) {
        torderDao.delete(torder);
    }

    @Override
    public List getAll() {
        return customerDao.getAll();
    }
}
