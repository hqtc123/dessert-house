package com.hqtc.dao;

import com.hqtc.HibernateSessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: He Qing
 * Date: 13-2-5
 * Time: 下午3:16
 * To change this template use File | Settings | File Templates.
 */
public abstract class BaseDao {
    protected void add(Object object) {
        Transaction tran = null;
        Session session = HibernateSessionFactory.getSession();
        try {
            tran = session.beginTransaction();
            session.save(object);
            tran.commit();
        } catch (Exception e) {
            if (tran != null) {
                tran.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    protected void delete(Object object) {
        Transaction tran = null;
        Session session = HibernateSessionFactory.getSession();
        try {
            tran = session.beginTransaction();
            session.delete(object);
            tran.commit();
        } catch (Exception e) {
            if (tran != null) {
                tran.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    protected void update(Object object) {
        Transaction tran = null;
        Session session = HibernateSessionFactory.getSession();
        try {
            tran = session.beginTransaction();
            session.update(object);
            tran.commit();
        } catch (Exception e) {
            if (tran != null) {
                tran.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    protected List search(Class cla, Object object) {
        List list = null;
        Session session = HibernateSessionFactory.getSession();
        try {
            list = session.createCriteria(cla).add(Example.create(object)).list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return list;
    }
}
