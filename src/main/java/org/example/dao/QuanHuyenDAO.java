package org.example.dao;

import org.example.model.QuanHuyen;
import org.example.utlis.HibernateUtlis;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class QuanHuyenDAO {

    private static String CLASS_NAME = QuanHuyen.class.getName();

    public boolean addQuanHuyen(QuanHuyen quanHuyen) {
        Session session = HibernateUtlis.getSession();
        Transaction transaction = session.getTransaction();
        try {
            transaction.begin();
            session.persist(quanHuyen);
            transaction.commit();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            transaction.rollback();
        }
        return false;
    }

    public List<QuanHuyen> getAllQuanHuyen() {
        Session session = HibernateUtlis.getSession();
        Transaction transaction = session.getTransaction();
        String sql = "select q from " + CLASS_NAME + " q";
        List<QuanHuyen> result = null;
        try {
            transaction.begin();
            Query<QuanHuyen> query = session.createQuery(sql, QuanHuyen.class);
            result = query.getResultList();
            transaction.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            transaction.rollback();
        }
        return result;
    }

    public List<QuanHuyen> getQuanHuyenInTinhTP(String maTinhTP) {
        Session session = HibernateUtlis.getSession();
        Transaction transaction = session.getTransaction();
        String sql = "select qh from " + CLASS_NAME + " qh where qh.tinhTP='" + maTinhTP + "'";
        List<QuanHuyen> result = null;
        try {
            transaction.begin();
            Query<QuanHuyen> query = session.createQuery(sql, QuanHuyen.class);
            result = query.getResultList();
            transaction.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            transaction.rollback();
        }
        return result;
    }

    public QuanHuyen getQuanHuyenById(String id) {
        Session session = HibernateUtlis.getSession();
        Transaction transaction = session.getTransaction();
        String sql = "select qh from " + CLASS_NAME + " qh where qh.id='" + id + "'";
        QuanHuyen quanHuyen = null;
        try {
            transaction.begin();
            Query<QuanHuyen> query = session.createQuery(sql, QuanHuyen.class);
            quanHuyen = query.getSingleResult();
            transaction.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            transaction.rollback();
        }
        return quanHuyen;
    }

}
