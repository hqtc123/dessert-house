package com.hqtc.model.dao;

import com.hqtc.model.entity.Torder;

/**
 * Created with IntelliJ IDEA.
 * User: hqtc
 * Date: 13-3-5
 * Time: 下午8:18
 * To change this template use File | Settings | File Templates.
 */
public interface TorderDao {
    public void add(Torder torder);

    public void delete(Torder torder);

    public void update(Torder torder);
}
