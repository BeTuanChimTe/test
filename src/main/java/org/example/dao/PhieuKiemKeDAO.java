package org.example.dao;

//import com.example.fashionshop.model.PhieuKiemKe;
//import com.example.fashionshop.utils.HibernateUtlis;
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
import org.example.model.PhieuKiemKe;
import org.example.utlis.HibernateUtlis;
import org.example.utlis.IDUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class PhieuKiemKeDAO {

    private static String className = PhieuKiemKe.class.getName();

    public  List<PhieuKiemKe> getAllPhieuKiemKe() {
        Session session = HibernateUtlis.getSession();
        Transaction transaction = session.getTransaction();
        String sql = "select pkk from " + className + " pkk";
        List<PhieuKiemKe> dsResult = null;
        try {
            transaction.begin();
            Query<PhieuKiemKe> query = session.createQuery(sql, PhieuKiemKe.class);
            dsResult = new ArrayList(query.getResultList());
//                    FXCollections.observableArrayList(query.getResultList());
            transaction.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            transaction.rollback();
        }
        return dsResult;
    }

    public  boolean addPhieuKiemKe(PhieuKiemKe phieuKiemKe) {
        phieuKiemKe.setMaPhieuKiemKe(IDUtils.createMaPhieuKiemKe());
        Session session = HibernateUtlis.getSession();
        Transaction transaction = session.getTransaction();
        try {
            transaction.begin();
            session.persist(phieuKiemKe);
            transaction.commit();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            transaction.rollback();
        }
        return false;
    }

    public  boolean updatePhieuKiemKe(PhieuKiemKe phieuKiemKe) {
        Session session = HibernateUtlis.getSession();
        Transaction transaction = session.getTransaction();
        try {
            transaction.begin();
            session.update(phieuKiemKe);
            transaction.commit();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            transaction.rollback();
        }
        return false;
    }

    public  boolean deletePhieuKiemKe(PhieuKiemKe phieuKiemKe) {
        Session session = HibernateUtlis.getSession();
        Transaction transaction = session.getTransaction();
        try {
            transaction.begin();
            session.remove(phieuKiemKe);
            transaction.commit();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            transaction.rollback();
        }
        return false;
    }
}
