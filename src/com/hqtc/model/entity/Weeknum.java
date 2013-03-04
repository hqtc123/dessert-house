package com.hqtc.model.entity;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created with IntelliJ IDEA.
 * User: He Qing
 * Date: 13-3-4
 * Time: 下午9:25
 * To change this template use File | Settings | File Templates.
 */
@Entity
public class Weeknum {
    private int id;

    @javax.persistence.Column(name = "id", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    @Id
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

    private int dessertid;

    @javax.persistence.Column(name = "dessertid", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    @Basic
    public int getDessertid() {
        return dessertid;
    }

    public void setDessertid(int dessertid) {
        this.dessertid = dessertid;
    }

    private int num;

    @javax.persistence.Column(name = "num", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    @Basic
    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Weeknum weeknum = (Weeknum) o;

        if (dessertid != weeknum.dessertid) return false;
        if (id != weeknum.id) return false;
        if (num != weeknum.num) return false;
        if (shopid != weeknum.shopid) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + shopid;
        result = 31 * result + dessertid;
        result = 31 * result + num;
        return result;
    }
}
