package com.hqtc.model;

import javax.persistence.Basic;
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
public class Dessert {
    private int id;

    @Column(name = "id", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    @Id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private String name;

    @Column(name = "name", nullable = false, insertable = true, updatable = true, length = 255, precision = 0)
    @Basic
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private float price;

    @Column(name = "price", nullable = false, insertable = true, updatable = true, length = 12, precision = 0)
    @Basic
    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Dessert dessert = (Dessert) o;

        if (id != dessert.id) return false;
        if (Float.compare(dessert.price, price) != 0) return false;
        if (name != null ? !name.equals(dessert.name) : dessert.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (price != +0.0f ? Float.floatToIntBits(price) : 0);
        return result;
    }
}
