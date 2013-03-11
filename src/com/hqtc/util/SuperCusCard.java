package com.hqtc.util;

import com.hqtc.model.entity.Card;
import com.hqtc.model.entity.Customer;

/**
 * Created with IntelliJ IDEA.
 * User: He Qing
 * Date: 13-3-11
 * Time: 上午11:06
 * To change this template use File | Settings | File Templates.
 */
public class SuperCusCard {
    private Customer customer;
    private Card card;

    public SuperCusCard(Customer customer, Card card) {
        this.customer = customer;
        this.card = card;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }
}
