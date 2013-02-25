package com.hqtc.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: He Qing
 * Date: 13-2-18
 * Time: 下午8:50
 * To change this template use File | Settings | File Templates.
 */
public class WeeknumPK implements Serializable {
    private int shopid;

    @Id
    @Column(name = "shopid", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    public int getShopid() {
        return shopid;
    }

    public void setShopid(int shopid) {
        this.shopid = shopid;
    }

    private int dessertid;

    @Id
    @Column(name = "dessertid", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    public int getDessertid() {
        return dessertid;
    }

    public void setDessertid(int dessertid) {
        this.dessertid = dessertid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WeeknumPK weeknumPK = (WeeknumPK) o;

        if (dessertid != weeknumPK.dessertid) return false;
        if (shopid != weeknumPK.shopid) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = shopid;
        result = 31 * result + dessertid;
        return result;
    }
}
