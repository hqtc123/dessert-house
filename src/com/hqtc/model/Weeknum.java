package com.hqtc.model;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * User: He Qing
 * Date: 13-2-18
 * Time: 下午8:50
 * To change this template use File | Settings | File Templates.
 */
@IdClass(WeeknumPK.class)
@Entity
public class Weeknum {
    private int shopid;

    @Column(name = "shopid", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    @Id
    public int getShopid() {
        return shopid;
    }

    public void setShopid(int shopid) {
        this.shopid = shopid;
    }

    private int dessertid;

    @Column(name = "dessertid", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    @Id
    public int getDessertid() {
        return dessertid;
    }

    public void setDessertid(int dessertid) {
        this.dessertid = dessertid;
    }

    private int num;

    @Column(name = "num", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
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
        if (num != weeknum.num) return false;
        if (shopid != weeknum.shopid) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = shopid;
        result = 31 * result + dessertid;
        result = 31 * result + num;
        return result;
    }
}
