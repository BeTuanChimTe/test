package org.example.dao;

//import com.example.fashionshop.model.DonHang;
//import com.example.fashionshop.utils.HibernateUtlis;
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
import org.example.model.DonHang;
import org.example.utlis.HibernateUtlis;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class DonHangDAO {

    private static String className = DonHang.class.getName();

    public  List<DonHang> getAllDonHang() {
        List<DonHang> listDonHang = null;
        String sqlQuery = "Select dh from " + className + " dh";

        Session session = HibernateUtlis.getSession();
        Transaction transaction = session.getTransaction();

        try {
            transaction.begin();
            Query<DonHang> query = session.createQuery(sqlQuery, DonHang.class);
            listDonHang =new ArrayList(query.getResultList());
//            FXCollections.observableArrayList(query.getResultList());
            transaction.commit();
        }
        catch (Exception exception) {
            exception.printStackTrace();
            transaction.rollback();
        }
        return listDonHang;
    }

    public  boolean addDonHang(DonHang donHang) {
        Session session = HibernateUtlis.getSession();
        Transaction transaction = session.getTransaction();
        try {
            transaction.begin();
            session.persist(donHang);
            transaction.commit();
            return true;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            transaction.rollback();
            return false;
        }
    }

    public  boolean updateDonHang(DonHang donHang) {
        Session session = HibernateUtlis.getSession();
        Transaction transaction = session.getTransaction();
        try {
            transaction.begin();
            session.update(donHang);
            transaction.commit();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public  boolean removeDonHang(DonHang donHang) {
        Session session = HibernateUtlis.getSession();
        Transaction transaction = session.getTransaction();
        try {
            transaction.begin();
            session.remove(donHang);
            transaction.commit();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
}
