package com.hqtc.util;

import com.hqtc.model.entity.Dessert;

/**
 * Created with IntelliJ IDEA.
 * User: He Qing
 * Date: 13-3-13
 * Time: 下午3:49
 * To change this template use File | Settings | File Templates.
 */
public class DessertNum {
    private Dessert dessert;
    private int num;

    public DessertNum(Dessert dessert, int num) {
        this.dessert = dessert;
        this.num = num;
    }

    public Dessert getDessert() {
        return dessert;
    }

    public void setDessert(Dessert dessert) {
        this.dessert = dessert;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}