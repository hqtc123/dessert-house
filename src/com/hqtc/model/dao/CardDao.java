package com.hqtc.model.dao;

import com.hqtc.model.entity.Card;

/**
 * Created with IntelliJ IDEA.
 * User: hqtc
 * Date: 13-3-5
 * Time: 上午10:46
 * To change this template use File | Settings | File Templates.
 */
public interface CardDao extends BaseDao<Card> {
    public Card findByCustomerId(int id);
}
