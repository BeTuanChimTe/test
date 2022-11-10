package org.example.dao;

import org.example.model.TinhTP;
import org.example.utlis.HibernateUtlis;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class TinhTPDAO {

    private final String CLASS_NAME = TinhTP.class.getName();

    public boolean addTinhTP(TinhTP tinhTP) {
        Session session = HibernateUtlis.getSession();
        Transaction transaction = session.getTransaction();
        try {
            transaction.begin();
            session.persist(tinhTP);
            transaction.commit();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            transaction.rollback();
        }
        return false;
    }

    public List<TinhTP> getAllTinhTP() {
        Session session = HibernateUtlis.getSession();
        Transaction transaction = session.getTransaction();
        String sql = "select t from " + CLASS_NAME + " t";
        List<TinhTP> result = null;
        try {
            transaction.begin();
            Query<TinhTP> query = session.createQuery(sql, TinhTP.class);
            result = query.getResultList();
            transaction.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            transaction.rollback();
        }
        return result;
    }

    public TinhTP getTinhTPById(String id) {
        Session session = HibernateUtlis.getSession();
        Transaction transaction = session.getTransaction();
        String sql = "select t from " + CLASS_NAME + " t where t.id='" + id + "'";
        TinhTP tinhTP = null;
        try {
            transaction.begin();
            Query<TinhTP> query = session.createQuery(sql, TinhTP.class);
            tinhTP = query.getSingleResult();
            transaction.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            transaction.rollback();
        }
        return tinhTP;
    }

}
