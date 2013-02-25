package com.hqtc.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created with IntelliJ IDEA.
 * User: He Qing
 * Date: 13-2-5
 * Time: 下午12:57
 * To change this template use File | Settings | File Templates.
 */
@Entity
public class Customer {
    private int id;

    @Column(name = "id", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    @Id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private int age;

    @Column(name = "age", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    @Basic
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    private int sex;

    @Column(name = "sex", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    @Basic
    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    private String address;

    @Column(name = "address", nullable = false, insertable = true, updatable = true, length = 255, precision = 0)
    @Basic
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    private String password;

    @Column(name = "password", nullable = false, insertable = true, updatable = true, length = 255, precision = 0)
    @Basic
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private String account;

    @Column(name = "account", nullable = false, insertable = true, updatable = true, length = 255, precision = 0)
    @Basic
    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Customer customer = (Customer) o;

        if (age != customer.age) return false;
        if (id != customer.id) return false;
        if (sex != customer.sex) return false;
        if (account != null ? !account.equals(customer.account) : customer.account != null) return false;
        if (address != null ? !address.equals(customer.address) : customer.address != null) return false;
        if (password != null ? !password.equals(customer.password) : customer.password != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + age;
        result = 31 * result + sex;
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (account != null ? account.hashCode() : 0);
        return result;
    }

    private int score;

    @Column(name = "score", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    @Basic
    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
