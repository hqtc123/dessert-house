package com.hqtc.biz;

import com.hqtc.model.entity.Dessert;
import com.hqtc.model.entity.Member;
import com.hqtc.model.entity.Order;
import com.hqtc.model.entity.Weeknum;

/**
 * Created with IntelliJ IDEA.
 * User: hqtc
 * Date: 13-3-7
 * Time: 下午3:37
 * To change this template use File | Settings | File Templates.
 */
public interface SalerBiz {
    public void dealOrder(Order order,Member member);

    public void manageDessert(Dessert dessert);

    public void manageWeekNum(Weeknum weeknum);
}
