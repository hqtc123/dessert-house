package com.hqtc.model.entity;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created with IntelliJ IDEA.
 * User: hqtc
 * Date: 13-3-7
 * Time: 下午4:01
 * To change this template use File | Settings | File Templates.
 */
@Entity
public class Strategy {
    private int id;

    @javax.persistence.Column(name = "id", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    @Id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private int score;

    @javax.persistence.Column(name = "score", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    @Basic
    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    private float discount;

    @javax.persistence.Column(name = "discount", nullable = false, insertable = true, updatable = true, length = 12, precision = 0)
    @Basic
    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Strategy strategy = (Strategy) o;

        if (Float.compare(strategy.discount, discount) != 0) return false;
        if (id != strategy.id) return false;
        if (score != strategy.score) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + score;
        result = 31 * result + (discount != +0.0f ? Float.floatToIntBits(discount) : 0);
        return result;
    }
}
