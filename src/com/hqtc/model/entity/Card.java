package com.hqtc.model.entity;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created with IntelliJ IDEA.
 * User: He Qing
 * Date: 13-3-4
 * Time: 下午9:24
 * To change this template use File | Settings | File Templates.
 */
@Entity
public class Card {
    private int id;

    @javax.persistence.Column(name = "id", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private String cardId;

    @javax.persistence.Column(name = "cardId", nullable = false, insertable = true, updatable = true, length = 255, precision = 0)
    @Basic
    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    private int customerId;

    @javax.persistence.Column(name = "customerId", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    @Basic
    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    private int state;

    @javax.persistence.Column(name = "state", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    @Basic
    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    private Date lastTme;

    @javax.persistence.Column(name = "lastTme", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    @Basic
    public Date getLastTme() {
        return lastTme;
    }

    public void setLastTme(Date lastTme) {
        this.lastTme = lastTme;
    }

    private float money;

    @javax.persistence.Column(name = "money", nullable = false, insertable = true, updatable = true, length = 12, precision = 0)
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
        if (id != card.id) return false;
        if (Float.compare(card.money, money) != 0) return false;
        if (state != card.state) return false;
        if (cardId != null ? !cardId.equals(card.cardId) : card.cardId != null) return false;
        if (lastTme != null ? !lastTme.equals(card.lastTme) : card.lastTme != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (cardId != null ? cardId.hashCode() : 0);
        result = 31 * result + customerId;
        result = 31 * result + state;
        result = 31 * result + (lastTme != null ? lastTme.hashCode() : 0);
        result = 31 * result + (money != +0.0f ? Float.floatToIntBits(money) : 0);
        return result;
    }
}
