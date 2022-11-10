package org.example.dao;

//import com.example.fashionshop.model.KichThuoc;
//import com.example.fashionshop.utils.HibernateUtlis;
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
import org.example.model.KichThuoc;
import org.example.utlis.HibernateUtlis;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class KichThuocDAO {

    private static String className = KichThuoc.class.getName();
    
    public  List<KichThuoc> getAllKichThuoc() {
        Session session = HibernateUtlis.getSession();
        Transaction transaction = session.getTransaction();
        List<KichThuoc> dsKichThuoc = null;
        try {
            transaction.begin();
            String selectQuery = "select kt from " + className + " kt";
            Query<KichThuoc> query = session.createQuery(selectQuery, KichThuoc.class);
            dsKichThuoc = new ArrayList(query.getResultList());
//                    FXCollections.observableArrayList(query.getResultList());
            transaction.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            transaction.rollback();
        }
        return dsKichThuoc;
    }

    public  KichThuoc getKichThuoc(int sizeId) {
        Session session = HibernateUtlis.getSession();
        Transaction transaction = session.getTransaction();
        KichThuoc kichThuoc = null;
        try {
            transaction.begin();
            String selectQuery = "SELECT kt FROM " + className + " kt WHERE kt.maKichThuoc=" + sizeId;
            Query<KichThuoc> query = session.createQuery(selectQuery, KichThuoc.class);
            kichThuoc = query.getSingleResult();
            transaction.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            transaction.rollback();
        }
        return kichThuoc;
    }

    public  boolean addKichThuoc(KichThuoc kichThuoc) {
        Session session = HibernateUtlis.getSession();
        Transaction transaction = session.getTransaction();
        try {
            transaction.begin();
            session.persist(kichThuoc);
            transaction.commit();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            transaction.rollback();
        }
        return false;
    }
    public  boolean updateKichThuoc(KichThuoc kichThuoc) {
        Session session = HibernateUtlis.getSession();
        Transaction transaction = session.getTransaction();
        try {
            transaction.begin();
            session.update(kichThuoc);
            transaction.commit();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            transaction.rollback();
        }
        return false;
    }
    public  boolean deleteKichThuoc(KichThuoc kichThuoc) {
        Session session = HibernateUtlis.getSession();
        Transaction transaction = session.getTransaction();
        try {
            transaction.begin();
            session.remove(kichThuoc);
            transaction.commit();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            transaction.rollback();
        }
        return false;
    }
}
