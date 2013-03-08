package com.hqtc.model.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: hqtc
 * Date: 13-3-7
 * Time: 下午4:26
 * To change this template use File | Settings | File Templates.
 */
@Entity
public class Member implements Serializable {
    private int id;

    @javax.persistence.Column(name = "id", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    @Id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private String account;

    @javax.persistence.Column(name = "account", nullable = false, insertable = true, updatable = true, length = 255, precision = 0)
    @Basic
    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    private String password;

    @javax.persistence.Column(name = "password", nullable = false, insertable = true, updatable = true, length = 255, precision = 0)
    @Basic
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private int position;

    @javax.persistence.Column(name = "position", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    @Basic
    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    private Shop shop;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shopid", nullable = false)
    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Member member = (Member) o;

        if (id != member.id) return false;
        if (position != member.position) return false;
        if (account != null ? !account.equals(member.account) : member.account != null) return false;
        if (password != null ? !password.equals(member.password) : member.password != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (account != null ? account.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + position;
        return result;
    }
}
