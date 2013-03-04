package com.hqtc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created with IntelliJ IDEA.
 * User: He Qing
 * Date: 13-2-18
 * Time: 下午8:50
 * To change this template use File | Settings | File Templates.
 */
@Entity
public class Shop {
    private int id;

    @Column(name = "id", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    @Id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Shop shop = (Shop) o;

        if (id != shop.id) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
