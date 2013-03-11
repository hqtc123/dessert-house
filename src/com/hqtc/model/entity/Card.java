package com.hqtc.model.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

/**
 * Created with IntelliJ IDEA.
 * User: He Qing
 * Date: 13-3-4
 * Time: 下午9:24
 * To change this template use File | Settings | File Templates.
 */
@Entity
public class Card implements Serializable {
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

    private int state;

    @javax.persistence.Column(name = "state", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    @Basic
    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
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

    private int customerid;

    @javax.persistence.Column(name = "customerid", nullable = false, insertable = true, updatable = true, length = 11, precision = 0)
    @Basic
    public int getCustomerid() {
        return customerid;
    }

    public void setCustomerid(int customerid) {
        this.customerid = customerid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Card card = (Card) o;

        if (id != card.id) return false;
        if (Float.compare(card.money, money) != 0) return false;
        if (state != card.state) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + state;
        result = 31 * result + (money != +0.0f ? Float.floatToIntBits(money) : 0);
        return result;
    }
}
