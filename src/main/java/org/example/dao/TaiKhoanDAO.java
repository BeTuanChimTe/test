package org.example.dao;

//import com.example.fashionshop.utils.HibernateUtlis;
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
import org.example.model.TaiKhoan;
import org.example.utlis.HibernateUtlis;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class TaiKhoanDAO {

    private static String className = TaiKhoan.class.getName();

    public  TaiKhoan getTaiKhoan(String maNhanVien) {
        Session session = HibernateUtlis.getSession();
        Transaction transaction = session.getTransaction();
        TaiKhoan taiKhoan = null;
        String sql = "Select tk from " + className + " tk where tk.maNhanVien='" + maNhanVien + "'";
        try {
            transaction.begin();
            Query<TaiKhoan> query = session.createQuery(sql, TaiKhoan.class);
            taiKhoan = query.getSingleResult();
            transaction.commit();
        } catch (Exception ex) {
            transaction.rollback();
        }
        return taiKhoan;
    }

    public  List<TaiKhoan> getAllTaiKhoan() {
        Session session = HibernateUtlis.getSession();
        Transaction transaction = session.getTransaction();
        List<TaiKhoan> dsTaiKhoan = null;
        String sql = "select tk from " + TaiKhoan.class.getName() + " tk";
        try {
            transaction.begin();
            Query<TaiKhoan> query = session.createQuery(sql, TaiKhoan.class);
            dsTaiKhoan = new ArrayList(query.getResultList());
            transaction.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            transaction.rollback();
        }
        return dsTaiKhoan;
    }


    public  boolean addTaiKhoan(TaiKhoan taiKhoan){
        Session session = HibernateUtlis.getSession();
        Transaction transaction = session.getTransaction();
        try {
            transaction.begin();
            session.persist(taiKhoan);
            transaction.commit();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            transaction.rollback();
            return false;
        }

    }
    public  boolean mergeTaiKhoan(TaiKhoan taiKhoan){
        taiKhoan.setMaNhanVien(taiKhoan.getNhanVien().getMaNhanVien());
        Session session = HibernateUtlis.getSession();
        Transaction transaction = session.getTransaction();
        try {
            transaction.begin();
            session.merge(taiKhoan);
            transaction.commit();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            transaction.rollback();
            return false;
        }

    }
    public  boolean updateTaiKhoan(TaiKhoan taiKhoan){
        Session session = HibernateUtlis.getSession();
        Transaction transaction = session.getTransaction();
        try {
            transaction.begin();
            session.update(taiKhoan);
            transaction.commit();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }
    public  boolean deleteTaiKhoan(TaiKhoan taiKhoan){
        Session session = HibernateUtlis.getSession();
        Transaction transaction = session.getTransaction();
        try {
            transaction.begin();
            session.remove(taiKhoan);
            transaction.commit();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

}
