package com.hqtc.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;

/**
 * Created with IntelliJ IDEA.
 * User: He Qing
 * Date: 13-2-19
 * Time: 下午9:26
 * To change this template use File | Settings | File Templates.
 */
@Entity
public class Card {
    private String cardid;

    @Column(name = "cardid", nullable = false, insertable = true, updatable = true, length = 255, precision = 0)
    @Id
    public String getCardid() {
        return cardid;
    }

    public void setCardid(String cardid) {
        this.cardid = cardid;
    }

    private int customerId;

    @Column(name = "customerId", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    @Basic
    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    private int state;

    @Column(name = "state", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    @Basic
    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    private Date lastTme;

    @Column(name = "lastTme", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    @Basic
    public Date getLastTme() {
        return lastTme;
    }

    public void setLastTme(Date lastTme) {
        this.lastTme = lastTme;
    }

    private float money;

    @Column(name = "money", nullable = false, insertable = true, updatable = true, length = 12, precision = 0)
    @Basic
    public float getMoney() {
        return money;
    }

    public void setMoney(float money) {
        this.money = money;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Card card = (Card) o;

        if (customerId != card.customerId) return false;
        if (Float.compare(card.money, money) != 0) return false;
        if (state != card.state) return false;
        if (cardid != null ? !cardid.equals(card.cardid) : card.cardid != null) return false;
        if (lastTme != null ? !lastTme.equals(card.lastTme) : card.lastTme != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = cardid != null ? cardid.hashCode() : 0;
        result = 31 * result + customerId;
        result = 31 * result + state;
        result = 31 * result + (lastTme != null ? lastTme.hashCode() : 0);
        result = 31 * result + (money != +0.0f ? Float.floatToIntBits(money) : 0);
        return result;
    }
}
