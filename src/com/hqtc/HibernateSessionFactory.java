package com.hqtc;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created with IntelliJ IDEA.
 * User: He Qing
 * Date: 13-2-5
 * Time: 下午2:42
 * To change this template use File | Settings | File Templates.
 * desc : create session
 */
public class HibernateSessionFactory {
    private static SessionFactory factory;
    private static ApplicationContext context;
    private static String[] configLocations = new String[]{"classpath:applicationContext.xml"};
    private static final ThreadLocal<Session> SESSION_THREAD_LOCAL = new ThreadLocal<Session>();

    static {
        try {
            context = new ClassPathXmlApplicationContext(configLocations);
            factory = context.getBean("sessionFactory", SessionFactory.class);
        } catch (Exception e) {
            System.err.println("Error occur when creating session factory");
            e.printStackTrace();
        }
    }

    private HibernateSessionFactory() {

    }

    public static Session getSession() {
        Session session = SESSION_THREAD_LOCAL.get();
        if (session == null || !session.isOpen()) {
            if (factory == null) {
                rebuildFactory();
            }
            session = (factory != null) ? factory.openSession() : null;
            SESSION_THREAD_LOCAL.set(session);
        }
        return session;
    }

    public static void closeSession(){
        Session session = (Session) SESSION_THREAD_LOCAL.get();
        SESSION_THREAD_LOCAL.set(null);

        if (session != null) {
            session.close();
        }
    }
    private static void rebuildFactory() {
        try {
            context = new ClassPathXmlApplicationContext(configLocations);
            factory = context.getBean("sessionFactory", SessionFactory.class);
        } catch (Exception e) {
            System.err.println("Error occur when creating session factory");
            e.printStackTrace();
        }
    }
}
