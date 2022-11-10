package org.example.dao;

//import com.example.fashionshop.model.NuocSanXuat;
//import com.example.fashionshop.utils.HibernateUtlis;
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
import org.example.model.NuocSanXuat;
import org.example.utlis.HibernateUtlis;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class NuocSanXuatDAO {

    private static String className = NuocSanXuat.class.getName();

    public  List<NuocSanXuat> getAllNuocSanXuat() {
        Session session = HibernateUtlis.getSession();
        Transaction transaction = session.getTransaction();
        List<NuocSanXuat> dsResult = null;
        try {
            transaction.begin();
            String selectQuery = "select th from " + className + " th";
            Query<NuocSanXuat> query = session.createQuery(selectQuery, NuocSanXuat.class);
            dsResult = new ArrayList(query.getResultList());
//                    FXCollections.observableArrayList(query.getResultList());
            transaction.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            transaction.rollback();
        }
        return dsResult;
    }

    public  NuocSanXuat getNuocSanXuat(int brandId) {
        Session session = HibernateUtlis.getSession();
        Transaction transaction = session.getTransaction();
        NuocSanXuat result = null;
        try {
            transaction.begin();
            String selectQuery = "SELECT th FROM " + className + " th WHERE th.maNuocSanXuat=" + brandId;
            Query<NuocSanXuat> query = session.createQuery(selectQuery, NuocSanXuat.class);
            result = query.getSingleResult();
            transaction.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            transaction.rollback();
        }
        return result;
    }

    public  boolean addNuocSanXuat(NuocSanXuat nuocSanXuat) {
        Session session = HibernateUtlis.getSession();
        Transaction transaction = session.getTransaction();
        try {
            transaction.begin();
            session.persist(nuocSanXuat);
            transaction.commit();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            transaction.rollback();
        }
        return false;
    }
    public  boolean updateNuocSanXuat(NuocSanXuat nuocSanXuat) {
        Session session = HibernateUtlis.getSession();
        Transaction transaction = session.getTransaction();
        try {
            transaction.begin();
            session.update(nuocSanXuat);
            transaction.commit();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            transaction.rollback();
        }
        return false;
    }
    public  boolean deleteNuocSanXuat(NuocSanXuat nuocSanXuat) {
        Session session = HibernateUtlis.getSession();
        Transaction transaction = session.getTransaction();
        try {
            transaction.begin();
            session.remove(nuocSanXuat);
            transaction.commit();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            transaction.rollback();
        }
        return false;
    }

}
