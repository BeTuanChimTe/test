package org.example.dao;

//import com.example.fashionshop.model.ThuongHieu;
//import com.example.fashionshop.utils.HibernateUtlis;
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
import org.example.model.ThuongHieu;
import org.example.utlis.HibernateUtlis;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class ThuongHieuDAO {

    private static String className = ThuongHieu.class.getName();

    public  List<ThuongHieu> getAllThuongHieu() {
        Session session = HibernateUtlis.getSession();
        Transaction transaction = session.getTransaction();
        List<ThuongHieu> dsResult = null;
        try {
            transaction.begin();
            String selectQuery = "select th from " + className + " th";
            Query<ThuongHieu> query = session.createQuery(selectQuery, ThuongHieu.class);
            dsResult =  new ArrayList(query.getResultList());
            transaction.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            transaction.rollback();
        }
        return dsResult;
    }

    public  ThuongHieu getThuongHieu(int brandId) {
        Session session = HibernateUtlis.getSession();
        Transaction transaction = session.getTransaction();
        ThuongHieu result = null;
        try {
            transaction.begin();
            String selectQuery = "SELECT th FROM " + className + " th WHERE th.maThuongHieu=" + brandId;
            Query<ThuongHieu> query = session.createQuery(selectQuery, ThuongHieu.class);
            result = query.getSingleResult();
            transaction.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            transaction.rollback();
        }
        return result;
    }

    public  boolean addThuongHieu(ThuongHieu thuongHieu) {
        Session session = HibernateUtlis.getSession();
        Transaction transaction = session.getTransaction();
        try {
            transaction.begin();
            session.persist(thuongHieu);
            transaction.commit();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            transaction.rollback();
        }
        return false;
    }
    public  boolean updateThuongHieu(ThuongHieu thuongHieu) {
        Session session = HibernateUtlis.getSession();
        Transaction transaction = session.getTransaction();
        try {
            transaction.begin();
            session.update(thuongHieu);
            transaction.commit();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            transaction.rollback();
        }
        return false;
    }
    public  boolean deleteThuongHieu(ThuongHieu thuongHieu) {
        Session session = HibernateUtlis.getSession();
        Transaction transaction = session.getTransaction();
        try {
            transaction.begin();
            session.remove(thuongHieu);
            transaction.commit();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            transaction.rollback();
        }
        return false;
    }

}
