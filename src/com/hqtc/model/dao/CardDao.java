package com.hqtc.model.dao;

import com.hqtc.model.entity.Card;

/**
 * Created with IntelliJ IDEA.
 * User: hqtc
 * Date: 13-3-5
 * Time: 上午10:46
 * To change this template use File | Settings | File Templates.
 */
public interface CardDao {
    public void add(Card card);

    public void delete(Card card);

    public void update(Card card);
}
