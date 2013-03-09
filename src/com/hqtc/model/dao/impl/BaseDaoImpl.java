package com.hqtc.model.dao.impl;

import com.hqtc.model.dao.BaseDao;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: He Qing
 * Date: 13-3-8
 * Time: 下午11:22
 * To change this template use File | Settings | File Templates.
 */
public abstract class BaseDaoImpl<T extends Serializable> implements BaseDao<T> {
    @Autowired
    private SessionFactory sessionFactory;
    private Class<T> persistentClass;

    @SuppressWarnings("unchecked")
    protected BaseDaoImpl() {
        // get class type of t
        //do not understand
        this.persistentClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public void save(T t) {
        getSession().save(t);
    }

    public void delete(T t) {
        getSession().delete(t);
    }

    public void update(T t) {
        getSession().update(t);
    }

    @SuppressWarnings("unchecked")
    public T findById(int id) {
        return (T) getSession().get(getPersistentClass(), id);
    }
    @SuppressWarnings("unchecked")
    public List<T> getAll() {
        return getSession().createCriteria(getPersistentClass()).list();
    }

    public Class<T> getPersistentClass() {
        return persistentClass;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<T> findByCriteria(Criterion... criterions) {
        Criteria criteria = getSession().createCriteria(getPersistentClass());
        for (Criterion c : criterions) {
            criteria.add(c);
        }
        return criteria.list();
    }
}
