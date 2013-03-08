package com.hqtc.model.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: hqtc
 * Date: 13-3-5
 * Time: 下午8:01
 * To change this template use File | Settings | File Templates.
 */
@Entity
public class Orderitem implements Serializable {
    private int id;

    @javax.persistence.Column(name = "id", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private Torder torder;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "orderid", nullable = false)
    public Torder getTorder() {
        return torder;
    }

    public void setTorder(Torder torder) {
        this.torder = torder;
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

        Orderitem orderitem = (Orderitem) o;

        if (dessertid != orderitem.dessertid) return false;
        if (id != orderitem.id) return false;
        if (num != orderitem.num) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + dessertid;
        result = 31 * result + num;
        return result;
    }
}
