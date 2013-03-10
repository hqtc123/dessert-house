package com.hqtc.model.dao.impl;

import com.hqtc.model.dao.CardDao;
import com.hqtc.model.entity.Card;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: He Qing
 * Date: 13-3-5
 * Time: 下午5:00
 * To change this template use File | Settings | File Templates.
 */
@Repository
public class CardDaoImpl extends BaseDaoImpl<Card> implements CardDao {

    @Override
    public Card findByCustomerId(int id) {
        Card card = null;
        Session session = getSession();
        Criteria criteria = session.createCriteria(Card.class);
        try {
            criteria.add(Restrictions.eq("customerid", id));
            List list = criteria.list();
            if (list.size() > 0) {
                card = (Card) list.get(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return card;
    }
}
