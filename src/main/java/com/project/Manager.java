package com.project;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Manager {

    private static SessionFactory factory;

    public static void createSessionFactory() {
        try {
            Configuration configuration = new Configuration();
            configuration.configure();
            StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()).build();
            factory = configuration.buildSessionFactory(serviceRegistry);
        } catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static void close() {
        factory.close();
    }

    public static <T> T addEntity(T entity) {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(entity);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
            entity = null;
        } finally {
            session.close();
        }
        return entity;
    }

    public static <T> T getById(Class<? extends T> clazz, Serializable id) {
        Session session = factory.openSession();
        Transaction tx = null;
        T obj = null;
        try {
            tx = session.beginTransaction();
            obj = clazz.cast(session.get(clazz, id));
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return obj;
    }

    public static <T> void updateEntity(T entity) {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.update(entity);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public static <T> void delete(Class<? extends T> clazz, Serializable id) {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            T obj = clazz.cast(session.get(clazz, id));
            session.delete(obj);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public static <T> Collection<?> listCollection(Class<? extends T> clazz) {
        return listCollection(clazz, "");
    }

    public static <T> Collection<?> listCollection(Class<? extends T> clazz, String where) {
        Session session = factory.openSession();
        Transaction tx = null;
        Collection<?> result = null;
        try {
            tx = session.beginTransaction();
            if (where.isEmpty()) {
                result = session.createQuery("FROM " + clazz.getName()).list();
            } else {
                result = session.createQuery("FROM " + clazz.getName() + " WHERE " + where).list();
            }
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return result;
    }

    public static <T> String collectionToString(Class<? extends T> clazz, Collection<?> collection) {
        StringBuilder txt = new StringBuilder();
        for (Object obj : collection) {
            T cObj = clazz.cast(obj);
            txt.append("\n").append(cObj.toString());
        }
        if (txt.length() > 0 && txt.charAt(0) == '\n') {
            txt.deleteCharAt(0);
        }
        return txt.toString();
    }

    public static void queryUpdate (String queryString) {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            SQLQuery query = session.createSQLQuery(queryString);
            query.executeUpdate();
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace(); 
        } finally {
            session.close(); 
        }
    }

    public static List<Object[]> queryTable (String queryString) {
        Session session = factory.openSession();
        Transaction tx = null;
        List<Object[]> result = null;
        try {
            tx = session.beginTransaction();
            SQLQuery query = session.createSQLQuery(queryString);
            @SuppressWarnings("unchecked")
            List<Object[]> rows = query.list();
            result = rows;
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace(); 
        } finally {
            session.close(); 
        }
        return result;
    }

    public static String tableToString (List<Object[]> rows) {
        String txt = "";
        for (Object[] row : rows) {
            for (Object cell : row) {
                txt += cell.toString() + ", ";
            }
            if (txt.length() >= 2 && txt.substring(txt.length() - 2).compareTo(", ") == 0) {
                txt = txt.substring(0, txt.length() - 2);
            }
            txt += "\n";
        }
        if (txt.length() >= 2) {
            txt =  txt.substring(0, txt.length() - 2);
        }
        return txt;
    }
}