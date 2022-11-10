package org.example.dao;

//import com.example.fashionshop.model.NhaCungCap;
//import com.example.fashionshop.utils.HibernateUtlis;
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
import org.example.model.NhaCungCap;
import org.example.utlis.HibernateUtlis;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class NhaCungCapDAO {

    private static String className = NhaCungCap.class.getName();

    public  List<NhaCungCap> getAllNhaCungCap() {
        List<NhaCungCap> dsNhaCungCap = null;
        Session session = HibernateUtlis.getSession();
        Transaction transaction = session.getTransaction();
        String sql = "select ncc from " + className + " ncc";
        try {
            transaction.begin();
            Query<NhaCungCap> query = session.createQuery(sql, NhaCungCap.class);
            dsNhaCungCap = new ArrayList(query.getResultList());
//            FXCollections.observableArrayList(query.getResultList());
            transaction.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return dsNhaCungCap;
    }

    public  boolean addNhaCungCap(NhaCungCap nhaCungCap) {
        Session session = HibernateUtlis.getSession();
        Transaction transaction = session.getTransaction();
        try {
            transaction.begin();
            session.persist(nhaCungCap);
            transaction.commit();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public  boolean updateNhaCungCap(NhaCungCap nhaCungCap) {
        Session session = HibernateUtlis.getSession();
        Transaction transaction = session.getTransaction();
        try {
            transaction.begin();
            session.update(nhaCungCap);
            transaction.commit();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public  boolean deleteNhaCungCap(NhaCungCap nhaCungCap) {
        Session session = HibernateUtlis.getSession();
        Transaction transaction = session.getTransaction();
        try {
            transaction.begin();
            session.remove(nhaCungCap);
            transaction.commit();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

}
