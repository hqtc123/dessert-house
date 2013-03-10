package com.hqtc.util;

import com.hqtc.model.entity.Dessert;
import com.hqtc.model.entity.Orderitem;

/**
 * Created with IntelliJ IDEA.
 * User: He Qing
 * Date: 13-3-10
 * Time: 下午10:10
 * To change this template use File | Settings | File Templates.
 */
public class SuperItem {
    private Dessert dessert;
    private Orderitem orderitem;

    public SuperItem(Dessert dessert, Orderitem orderitem) {
        this.dessert = dessert;
        this.orderitem = orderitem;
    }

    public Dessert getDessert() {
        return dessert;
    }

    public void setDessert(Dessert dessert) {
        this.dessert = dessert;
    }

    public Orderitem getOrderitem() {
        return orderitem;
    }

    public void setOrderitem(Orderitem orderitem) {
        this.orderitem = orderitem;
    }
}
