package com.hqtc.biz.impl;

import com.hqtc.biz.SalerBiz;
import com.hqtc.model.dao.*;
import com.hqtc.model.entity.*;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: hqtc
 * Date: 13-3-7
 * Time: 下午4:15
 * To change this template use File | Settings | File Templates.
 */
@Service
public class SalerBizImpl extends MemberBizImpl implements SalerBiz {
    @Autowired
    private TorderDao torderDao;
    @Autowired
    private CustomerDao customerDao;
    @Autowired
    private DessertDao dessertDao;
    @Autowired
    private WeeknumDao weeknumDao;
    @Autowired
    private ShopDao shopDao;

    @Override
    public void dealOrder(Torder torder, Member member) {
        torder.setSalerid(member.getId());
        Customer customer = customerDao.findById(torder.getCustomerid());
        int oldScore = customer.getScore();
        int newScore = oldScore + (int) torder.getMoney();
        customer.setScore(newScore);

        torderDao.update(torder);
        customerDao.update(customer);
    }

    @Override
    public void addDessert(Dessert dessert) {
        dessertDao.save(dessert);
    }

    @Override
    public void deleteDessert(Dessert dessert) {
        dessertDao.delete(dessert);
    }

    @Override
    public void updateDessert(Dessert dessert) {
        dessertDao.update(dessert);
    }

    @Override
    public Dessert getDessertById(int id) {
        return dessertDao.findById(id);
    }

    @Override
    public List getAllDesserts() {
        return dessertDao.getAll();
    }

    @Override
    public List<Weeknum> getWeekNumByShopDay(Weeknum weeknum1) {
        return weeknumDao.getWeekNumByShopDay(weeknum1);
    }

    @Override
    public Weeknum getWeeknumById(int id) {
        return weeknumDao.findById(id);
    }

    @Override
    public void deleteWeeknum(Weeknum weeknum1) {
        weeknumDao.delete(weeknum1);
    }

    @Override
    public void addWeeknum(Weeknum weeknum) {
        weeknumDao.save(weeknum);
    }
}
