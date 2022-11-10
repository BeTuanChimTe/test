package org.example.dao;

import org.example.model.KhachHang;
import org.example.utlis.HibernateUtlis;


import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class KhachHangDAO {

    private static String className = KhachHang.class.getName();

    public List<KhachHang> getAllCustomer() {
        List<KhachHang> listKhachHang = null;
        String sqlQuery = "Select kh from " + className + " kh";

        Session session = HibernateUtlis.getSession();
        Transaction transaction = session.getTransaction();

        try {
            transaction.begin();
            Query<KhachHang> query = session.createQuery(sqlQuery, KhachHang.class);
            listKhachHang = new ArrayList(query.getResultList());
            transaction.commit();
        }
        catch (Exception exception) {
            exception.printStackTrace();
            transaction.rollback();
        }
        return listKhachHang;
    }

    public boolean addCustomer(KhachHang khachHang) {
        Session session = HibernateUtlis.getSession();
        Transaction transaction = session.getTransaction();
        try {
            transaction.begin();
            session.persist(khachHang);
            transaction.commit();
            return true;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            transaction.rollback();
            return false;
        }
    }

    public boolean updateCustomer(KhachHang khachHang) {
        Session session = HibernateUtlis.getSession();
        Transaction transaction = session.getTransaction();
        try {
            transaction.begin();
            session.update(khachHang);
            transaction.commit();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public boolean removeCustomer(KhachHang khachHang) {
        Session session = HibernateUtlis.getSession();
        Transaction transaction = session.getTransaction();
        try {
            transaction.begin();
            session.remove(khachHang);
            transaction.commit();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
}
