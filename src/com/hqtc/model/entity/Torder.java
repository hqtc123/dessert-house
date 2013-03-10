package com.hqtc.model.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: He Qing
 * Date: 13-3-4
 * Time: 下午9:25
 * To change this template use File | Settings | File Templates.
 */
@Entity
public class Torder implements Serializable {
    private int id;

    @Column(name = "id", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private int shopid;

    @Column(name = "shopid", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    @Basic
    public int getShopid() {
        return shopid;
    }

    public void setShopid(int shopid) {
        this.shopid = shopid;
    }

    private int salerid;

    @Column(name = "salerid", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    @Basic
    public int getSalerid() {
        return salerid;
    }

    public void setSalerid(int salerid) {
        this.salerid = salerid;
    }

    private int customerid;

    @Column(name = "customerid", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    @Basic
    public int getCustomerid() {
        return customerid;
    }

    public void setCustomerid(int customerid) {
        this.customerid = customerid;
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

    private Set<Orderitem> orderitems;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "torder")
    public Set<Orderitem> getOrderitems() {
        return orderitems;
    }

    public void setOrderitems(Set<Orderitem> orderitems) {
        this.orderitems = orderitems;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Torder torder = (Torder) o;

        if (customerid != torder.customerid) return false;
        if (id != torder.id) return false;
        if (Float.compare(torder.money, money) != 0) return false;
        if (salerid != torder.salerid) return false;
        if (shopid != torder.shopid) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + shopid;
        result = 31 * result + salerid;
        result = 31 * result + customerid;
        result = 31 * result + (money != +0.0f ? Float.floatToIntBits(money) : 0);
        return result;
    }
}
