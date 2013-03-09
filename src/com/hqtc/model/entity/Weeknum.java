package com.hqtc.model.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: He Qing
 * Date: 13-3-4
 * Time: 下午9:25
 * To change this template use File | Settings | File Templates.
 */
@Entity
public class Weeknum implements Serializable {
    private int id;

    @Column(name = "id", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    @Id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private Shop shop;
    private Dessert dessert;

    @ManyToOne
    @JoinColumn(name = "shopid", nullable = false)
    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    @ManyToOne
    @JoinColumn(name = "dessertid", nullable = false)
    public Dessert getDessert() {
        return dessert;
    }

    public void setDessert(Dessert dessert) {
        this.dessert = dessert;
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

        if (id != weeknum.id) return false;
        if (num != weeknum.num) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + num;
        return result;
    }

    private int weekday;

    @Column(name = "weekday", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    @Basic
    public int getWeekday() {
        return weekday;
    }

    public void setWeekday(int weekday) {
        this.weekday = weekday;
    }
}
