package com.hqtc.biz.impl;

import com.hqtc.biz.SalerBiz;
import com.hqtc.model.dao.CustomerDao;
import com.hqtc.model.dao.DessertDao;
import com.hqtc.model.dao.TorderDao;
import com.hqtc.model.dao.WeeknumDao;
import com.hqtc.model.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * User: hqtc
 * Date: 13-3-7
 * Time: 下午4:15
 * To change this template use File | Settings | File Templates.
 */
@Service
public class SalerBizImpl implements SalerBiz {
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
    public void manageDessert(Dessert dessert) {
        dessertDao.update(dessert);
    }

    @Override
    public void manageWeekNum(Weeknum weeknum) {
        weeknumDao.update(weeknum);
    }
}
