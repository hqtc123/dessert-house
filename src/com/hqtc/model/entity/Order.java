package com.hqtc.model.entity;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * User: He Qing
 * Date: 13-3-4
 * Time: 下午9:25
 * To change this template use File | Settings | File Templates.
 */
@Entity
public class Order {
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

    private int shopid;

    @javax.persistence.Column(name = "shopid", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    @Basic
    public int getShopid() {
        return shopid;
    }

    public void setShopid(int shopid) {
        this.shopid = shopid;
    }

    private int salerid;

    @javax.persistence.Column(name = "salerid", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    @Basic
    public int getSalerid() {
        return salerid;
    }

    public void setSalerid(int salerid) {
        this.salerid = salerid;
    }

    private int customerid;

    @javax.persistence.Column(name = "customerid", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    @Basic
    public int getCustomerid() {
        return customerid;
    }

    public void setCustomerid(int customerid) {
        this.customerid = customerid;
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

    private int state;

    @javax.persistence.Column(name = "state", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    @Basic
    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        if (customerid != order.customerid) return false;
        if (id != order.id) return false;
        if (Float.compare(order.money, money) != 0) return false;
        if (salerid != order.salerid) return false;
        if (shopid != order.shopid) return false;
        if (state != order.state) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + shopid;
        result = 31 * result + salerid;
        result = 31 * result + customerid;
        result = 31 * result + (money != +0.0f ? Float.floatToIntBits(money) : 0);
        result = 31 * result + state;
        return result;
    }
}
