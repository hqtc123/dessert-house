package com.hqtc.model.dao;

import com.hqtc.model.entity.Orderitem;

/**
 * Created with IntelliJ IDEA.
 * User: hqtc
 * Date: 13-3-5
 * Time: 下午8:04
 * To change this template use File | Settings | File Templates.
 */
public interface OrderitemDao {
    public void add(Orderitem orderitemr);

    public void delete(Orderitem orderitemr);

    public void update(Orderitem orderitemr);
}
