package com.hqtc.model.dao;

import com.hqtc.model.entity.Dessert;

/**
 * Created with IntelliJ IDEA.
 * User: hqtc
 * Date: 13-3-5
 * Time: 上午10:46
 * To change this template use File | Settings | File Templates.
 */
public interface DessertDao {
    public void add(Dessert dessert);

    public void delete(Dessert dessert);

    public void update(Dessert dessert);
}
