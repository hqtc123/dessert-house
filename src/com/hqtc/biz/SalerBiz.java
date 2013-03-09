package com.hqtc.biz;

import com.hqtc.model.entity.Dessert;
import com.hqtc.model.entity.Member;
import com.hqtc.model.entity.Torder;
import com.hqtc.model.entity.Weeknum;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: hqtc
 * Date: 13-3-7
 * Time: 下午3:37
 * To change this template use File | Settings | File Templates.
 */
public interface SalerBiz extends MemberBiz {
    public void dealOrder(Torder torder, Member member);

    public void addDessert(Dessert dessert);

    public void deleteDessert(Dessert dessert);

    public void updateDessert(Dessert dessert);

    public Dessert getDessertById(int id);

    public List getAllDesserts();

    List<Weeknum> getWeekNumByShopDay(Weeknum weeknum1);
}
