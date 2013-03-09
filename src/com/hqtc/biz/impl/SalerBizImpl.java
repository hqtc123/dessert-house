package com.hqtc.biz.impl;

import com.hqtc.biz.SalerBiz;
import com.hqtc.model.dao.CustomerDao;
import com.hqtc.model.dao.DessertDao;
import com.hqtc.model.dao.TorderDao;
import com.hqtc.model.dao.WeeknumDao;
import com.hqtc.model.entity.*;
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

    @Override
    public void dealOrder(Torder torder, Member member) {
        torder.setSalerid(member.getId());
        Customer customer = customerDao.findById(torder.getCustomerid());
        int oldScore = customer.getScore();
        int newScore = oldScore + (int) torder.getRealmoney();
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
    public List getAllWeeknums() {
        return null;  //todo
    }

    @Override
    public void manageWeekNum(Weeknum weeknum) {
        weeknumDao.update(weeknum);
    }
}
