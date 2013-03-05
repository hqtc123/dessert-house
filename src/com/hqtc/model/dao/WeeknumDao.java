package com.hqtc.model.dao;

import com.hqtc.model.entity.Weeknum;

/**
 * Created with IntelliJ IDEA.
 * User: hqtc
 * Date: 13-3-5
 * Time: 下午8:20
 * To change this template use File | Settings | File Templates.
 */
public interface WeeknumDao {
    public void add(Weeknum weeknum);

    public void delete(Weeknum weeknum);

    public void update(Weeknum weeknum);
}
