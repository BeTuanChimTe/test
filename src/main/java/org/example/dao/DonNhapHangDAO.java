package org.example.dao;

//import com.example.fashionshop.model.DonNhapHang;
//import com.example.fashionshop.utils.HibernateUtlis;
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
import org.example.model.DonNhapHang;
import org.example.utlis.HibernateUtlis;
import org.example.utlis.IDUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class DonNhapHangDAO {

    private  static String CLASS_NAME = DonNhapHang.class.getName();

    public  List<DonNhapHang> getAllDonNhapHang() {
        Session session = HibernateUtlis.getSession();
        Transaction transaction = session.getTransaction();
        String sql = "select dnh from " + CLASS_NAME + " dnh";
        List<DonNhapHang> dsDonNhapHang = null;
        try {
            transaction.begin();
            Query<DonNhapHang> query = session.createQuery(sql, DonNhapHang.class);
            dsDonNhapHang = new ArrayList(query.getResultList());
            transaction.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            transaction.rollback();
        }
        return dsDonNhapHang;
    }

    public  boolean addDonNhapHang(DonNhapHang donNhapHang) {
        donNhapHang.setMaDonNhapHang(IDUtils.createMaDonNhapHang());
        Session session = HibernateUtlis.getSession();
        Transaction transaction = session.getTransaction();
        try {
            transaction.begin();
            session.persist(donNhapHang);
            transaction.commit();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            transaction.rollback();
        }
        return false;
    }

    public  boolean updateDonNhapHang(DonNhapHang donNhapHang) {
        Session session = HibernateUtlis.getSession();
        Transaction transaction = session.getTransaction();
        try {
            transaction.begin();
            session.update(donNhapHang);
            transaction.commit();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            transaction.rollback();
        }
        return false;
    }

    public  boolean deleteDonNhapHang(DonNhapHang donNhapHang) {
        Session session = HibernateUtlis.getSession();
        Transaction transaction = session.getTransaction();
        try {
            transaction.begin();
            session.remove(donNhapHang);
            transaction.commit();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            transaction.rollback();
        }
        return false;
    }

}
