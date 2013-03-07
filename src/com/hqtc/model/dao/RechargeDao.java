package com.hqtc.model.dao;

import com.hqtc.model.entity.Recharge;

/**
 * Created with IntelliJ IDEA.
 * User: hqtc
 * Date: 13-3-7
 * Time: 下午4:38
 * To change this template use File | Settings | File Templates.
 */
public interface RechargeDao {
    public void add(Recharge recharge);

    public void delete(Recharge recharge);

    public void update(Recharge recharge);
}
