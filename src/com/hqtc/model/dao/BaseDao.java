package com.hqtc.model.dao;

import org.hibernate.criterion.Criterion;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: He Qing
 * Date: 13-3-8
 * Time: 下午11:18
 * To change this template use File | Settings | File Templates.
 */
public interface BaseDao<T> {
    void save(T t);

    void update(T t);

    void delete(T t);

    T findById(int i);

    List<T> findByCriteria(Criterion... criterions);
}
