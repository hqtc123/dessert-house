package com.hqtc.model.dao;

import com.hqtc.model.entity.Weeknum;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: hqtc
 * Date: 13-3-5
 * Time: 下午8:20
 * To change this template use File | Settings | File Templates.
 */
public interface WeeknumDao extends BaseDao<Weeknum> {
    public List<Weeknum> getWeekNumByShopDay(Weeknum weeknum1);
}
