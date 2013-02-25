package com.hqtc.model;

import javax.persistence.Basic;
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
public class Member {
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

    private int shopid;

    @javax.persistence.Column(name = "shopid", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    @Basic
    public int getShopid() {
        return shopid;
    }

    public void setShopid(int shopid) {
        this.shopid = shopid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Member member = (Member) o;

        if (id != member.id) return false;
        if (position != member.position) return false;
        if (shopid != member.shopid) return false;
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
        result = 31 * result + shopid;
        return result;
    }
}
