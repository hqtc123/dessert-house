package com.hqtc.model.dao;

import com.hqtc.model.entity.Shop;

/**
 * Created with IntelliJ IDEA.
 * User: hqtc
 * Date: 13-3-5
 * Time: 上午10:47
 * To change this template use File | Settings | File Templates.
 */
public interface ShopDao {
    public void add(Shop shop);

    public void delete(Shop shop);

    public void update(Shop shop);
}
