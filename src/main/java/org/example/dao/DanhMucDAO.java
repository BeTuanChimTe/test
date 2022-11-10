package org.example.dao;

//import com.example.fashionshop.model.DanhMuc;
//import com.example.fashionshop.utils.HibernateUtlis;
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
import org.example.model.DanhMuc;
import org.example.utlis.HibernateUtlis;
import org.example.utlis.IDUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class DanhMucDAO {
    
    private static String className = DanhMuc.class.getName();

    public List<DanhMuc> getAllCategory() {
        Session session = HibernateUtlis.getSession();
        Transaction transaction = session.getTransaction();
        List<DanhMuc> dsDanhMuc = null;
        try {
            transaction.begin();
            String selectQuery = "select dm from " + className + " dm";
            Query<DanhMuc> query = session.createQuery(selectQuery, DanhMuc.class);
            dsDanhMuc = new ArrayList(query.getResultList());
//                    FXCollections.observableArrayList(query.getResultList());
            transaction.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            transaction.rollback();
        }
        return dsDanhMuc;
    }

    public boolean addCategory(DanhMuc danhMuc) {
        danhMuc.setMaDanhMuc(IDUtils.createMaDanhMuc());
        Session session = HibernateUtlis.getSession();
        Transaction transaction = session.getTransaction();

        try {
            transaction.begin();
            session.persist(danhMuc);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
            return false;
        }
    }

    public boolean updateCategory(DanhMuc danhMuc) {
        Session session = HibernateUtlis.getSession();
        Transaction transaction = session.getTransaction();
        try {
            transaction.begin();
            session.update(danhMuc);
            transaction.commit();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public boolean removeCategory(DanhMuc danhMuc) {
        Session session = HibernateUtlis.getSession();
        Transaction transaction = session.getTransaction();
        try {
            transaction.begin();
            session.remove(danhMuc);
            transaction.commit();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public DanhMuc getCategoryById(String category_id) {
        Session session = HibernateUtlis.getSession();
        Transaction transaction = session.getTransaction();
        DanhMuc danhMuc = null;
        try
        {
            transaction.begin();
            String selectQuery = "Select dm from " + className +" dm where dm.maDanhMuc='" + category_id + "'";
            Query<DanhMuc> query = session.createQuery(selectQuery, DanhMuc.class);
            danhMuc = query.getSingleResult();
            transaction.commit();
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            transaction.rollback();
        }
        return danhMuc;
    }

}
