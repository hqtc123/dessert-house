package com.hqtc.model.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: He Qing
 * Date: 13-2-5
 * Time: 下午3:16
 * To change this template use File | Settings | File Templates.
 */
public abstract class BaseDao {

    @Autowired
    SessionFactory sessionFactory;

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    protected void add(Object object) {
        getSession().save(object);
    }

    protected void delete(Object object) {
        getSession().delete(object);
    }

    protected void update(Object object) {
        getSession().update(object);
    }

    protected Object get(Class cla, Serializable id) {
        return getSession().get(cla, id);
    }

    protected List search(Class cla, Object object) {
        return getSession().createCriteria(cla).add(Example.create(object)).list();
    }
}
