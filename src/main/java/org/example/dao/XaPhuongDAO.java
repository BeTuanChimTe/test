package org.example.dao;

import org.example.model.XaPhuong;
import org.example.utlis.HibernateUtlis;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class XaPhuongDAO {

    private final String CLASS_NAME = XaPhuong.class.getName();

    public boolean addXaPhuong(XaPhuong xaPhuong) {
        Session session = HibernateUtlis.getSession();
        Transaction transaction = session.getTransaction();
        try {
            transaction.begin();
            session.persist(xaPhuong);
            transaction.commit();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            transaction.rollback();
        }
        return false;
    }

    public List<XaPhuong> getAllXaPhuong() {
        Session session = HibernateUtlis.getSession();
        Transaction transaction = session.getTransaction();
        String sql = "select x from " + CLASS_NAME + " x";
        List<XaPhuong> result = null;
        try {
            transaction.begin();
            Query<XaPhuong> query = session.createQuery(sql, XaPhuong.class);
            result = query.getResultList();
            transaction.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            transaction.rollback();
        }
        return result;
    }

    public List<XaPhuong> getXaPhuongInQuanHuyen(String maQuanHuyen) {
        Session session = HibernateUtlis.getSession();
        Transaction transaction = session.getTransaction();
        String sql = "select xp from " + CLASS_NAME + " xp where xp.quanHuyen='" + maQuanHuyen + "'";
        List<XaPhuong> result = null;
        try {
            transaction.begin();
            Query<XaPhuong> query = session.createQuery(sql, XaPhuong.class);
            result = query.getResultList();
            transaction.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            transaction.rollback();
        }
        return result;
    }

    public XaPhuong getXaPhuongById(String id) {
        Session session = HibernateUtlis.getSession();
        Transaction transaction = session.getTransaction();
        String sql = "select xp from " + CLASS_NAME + " xp where xp.id='" + id + "'";
        XaPhuong xaPhuong = null;
        try {
            transaction.begin();
            Query<XaPhuong> query = session.createQuery(sql, XaPhuong.class);
            xaPhuong = query.getSingleResult();
            transaction.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            transaction.rollback();
        }
        return xaPhuong;
    }

}
