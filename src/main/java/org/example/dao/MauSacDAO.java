package org.example.dao;

//import com.example.fashionshop.model.MauSac;
//import com.example.fashionshop.utils.HibernateUtlis;
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
import org.example.model.MauSac;
import org.example.utlis.HibernateUtlis;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class MauSacDAO {

    private static String className = MauSac.class.getName();

    public  List<MauSac> getAllMauSac() {
        Session session = HibernateUtlis.getSession();
        Transaction transaction = session.getTransaction();
        List<MauSac> dsMauSac = null;
        try {
            transaction.begin();
            String selectQuery = "select ms from " + className + " ms";
            Query<MauSac> query = session.createQuery(selectQuery, MauSac.class);
            dsMauSac = new ArrayList(query.getResultList());
//                    FXCollections.observableArrayList(query.getResultList());
            transaction.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            transaction.rollback();
        }
        return dsMauSac;
    }

    public  MauSac getMauSac(int colorId) {
        Session session = HibernateUtlis.getSession();
        Transaction transaction = session.getTransaction();
        MauSac mauSac = null;
        try {
            transaction.begin();
            String selectQuery = "SELECT ms FROM " + className + " ms WHERE ms.maMau=" + colorId;
            Query<MauSac> query = session.createQuery(selectQuery, MauSac.class);
            mauSac = query.getSingleResult();
            transaction.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            transaction.rollback();
        }
        return mauSac;
    }

    public  boolean addMauSac(MauSac mauSac) {

        Session session = HibernateUtlis.getSession();
        Transaction transaction = session.getTransaction();
        try {
            transaction.begin();
            session.persist(mauSac);
            transaction.commit();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            transaction.rollback();
        }
        return false;
    }

    public  boolean updateMauSac(MauSac mauSac) {
        Session session = HibernateUtlis.getSession();
        Transaction transaction = session.getTransaction();
        try {
            transaction.begin();
            session.update(mauSac);
            transaction.commit();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            transaction.rollback();
        }
        return false;
    }

    public  boolean deleteMauSac(MauSac mauSac) {
        Session session = HibernateUtlis.getSession();
        Transaction transaction = session.getTransaction();
        try {
            transaction.begin();
            session.remove(mauSac);
            transaction.commit();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            transaction.rollback();
        }
        return false;
    }
}
