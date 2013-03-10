package com.hqtc.util;

import com.hqtc.model.entity.Weeknum;

/**
 * Created with IntelliJ IDEA.
 * User: He Qing
 * Date: 13-3-10
 * Time: 下午8:48
 * To change this template use File | Settings | File Templates.
 */
public class SuperWeeknum {
    private Weeknum weeknum;
    private float dessertPrice;

    public SuperWeeknum(Weeknum weeknum, float dessertPrice) {
        this.weeknum = weeknum;
        this.dessertPrice = dessertPrice;
    }

    public Weeknum getWeeknum() {
        return weeknum;
    }

    public void setWeeknum(Weeknum weeknum) {
        this.weeknum = weeknum;
    }

    public float getDessertPrice() {
        return dessertPrice;
    }

    public void setDessertPrice(float dessertPrice) {
        this.dessertPrice = dessertPrice;
    }
}
