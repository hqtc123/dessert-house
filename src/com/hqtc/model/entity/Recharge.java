package com.hqtc.model.entity;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;

/**
 * Created with IntelliJ IDEA.
 * User: hqtc
 * Date: 13-3-7
 * Time: 下午3:25
 * To change this template use File | Settings | File Templates.
 */
@Entity
public class Recharge {
    private int id;

    @javax.persistence.Column(name = "id", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    @Id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private int customerid;

    @javax.persistence.Column(name = "customerid", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    @Basic
    public int getCustomerid() {
        return customerid;
    }

    public void setCustomerid(int customerid) {
        this.customerid = customerid;
    }

    private int money;

    @javax.persistence.Column(name = "money", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    @Basic
    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    private Date date;

    @javax.persistence.Column(name = "date", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    @Basic
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Recharge recharge = (Recharge) o;

        if (customerid != recharge.customerid) return false;
        if (id != recharge.id) return false;
        if (money != recharge.money) return false;
        if (date != null ? !date.equals(recharge.date) : recharge.date != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + customerid;
        result = 31 * result + money;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        return result;
    }
}
